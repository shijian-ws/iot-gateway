package org.sj.iot.gateway.connection.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutor;
import org.sj.iot.gateway.connection.util.ChannelUtil;
import org.sj.iot.gateway.data.model.Gatewayinfo;
import org.sj.iot.gateway.data.service.IControlService;
import org.sj.iot.model.DataBody;
import org.sj.iot.model.Message;
import org.sj.iot.model.MessageV2;
import org.sj.iot.model.Processable;
import org.sj.iot.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * 云端消息进站解码处理器v2版本
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-14
 */
@Sharable
@Component
public class CloudMessageDecoderV2 extends SimpleChannelInboundHandler<ByteBuf> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CloudMessageDecoderV2.class);

    @Autowired
    private IControlService controlService;

    /**
     * 网关初始连接发送信息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        EventExecutor executor = ctx.executor();
        executor.execute(() -> {
            Channel channel = ctx.channel(); // 获取当前所属通道
            Gatewayinfo info = controlService.getgatewayinfo(); // 查询数据库网关设备信息
            String mac = ChannelUtil.getMac(channel); // 获取通道所属mac地址
            byte messageId = MessageV2Util.createMessageId(mac); // 生成消息id
            // 创建云端消息
            DataBody body = new DataBody(info);
            Message request = MessageV2Util.createMessage(mac, messageId, body); // 创建请求消息对象
            // 生成请求消息回调处理函数
            ProcessUtil.set(mac, messageId, result -> {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("初始化, 服务器端响应: {}", result);
                }
            });
            ChannelUtil.writeMessage(ctx, request); // 写出消息
            LongAdder counter = new LongAdder(); // 创建个数计算器
            try {
                // 启动一个6秒之后每个6秒执行一次的定时器
                executor.scheduleWithFixedDelay(() -> {
                    counter.increment();
                    if (!channel.isActive() || counter.intValue() == 10) {
                        ProcessUtil.remove(mac, messageId); // 移除任务处理器
                        throw new IllegalStateException("通道已关闭或已经连续10次服务端无响应, 结束初始化定时器标识!");
                    }
                    Processable<Map<String, Object>> call = ProcessUtil.get(mac, messageId);
                    if (call != null) {
                        // 还存在任务处理器, 服务器没有响应, 重发
                        ChannelUtil.writeMessage(ctx, request);
                        return;
                    }
                    throw new IllegalStateException("网关信息已被响应, 结束初始化定时器标识!");
                }, 6, 6, TimeUnit.SECONDS);
            } catch (Exception e) {
                if (LOGGER.isErrorEnabled()) {
                    LOGGER.error("初始化定时器发送网关信息失败: {}", e.getMessage());
                }
            }
        });
        ctx.fireChannelActive();
    }

    /**
     * 云端消息入站解码
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        Channel channel = ctx.channel();
        String addrInfo = channel.remoteAddress().toString();
        int magic = msg.readInt(); // 获取魔数头，4个字节
        if (!MessageV2Util.checkMagic(magic)) {
            // 非法魔数
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("非法魔数请求: {}", addrInfo);
            }
            return;
        }
        int packetLength = msg.readInt(); // 数据包从获取从version到checksum的长度, 4个字节
        byte version = msg.readByte(); // 获取版本号，1个字节
        if (Constants.V2.VERSION != version) {
            // 非法版本号
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("当前版本[{}], 不支持版本[{}]", Constants.V2.VERSION, version);
            }
            return;
        }
        // long mac = ((long) msg.readShort() << 32) | msg.readInt(); // 客户端MAC地址, 6个字节, 如果不先将short类型转换为long则位运算时将会出现超出位舍弃
        long mac = Tools.macToLong(ChannelUtil.readAsBuffer(msg, 6)); // 从缓冲读取6个字节数据然后转换为long值
        byte messageId = msg.readByte(); // 获取消息ID，1个字节
        int dataLength = MessageV2Util.getDataLength(packetLength); // 业务数据长度
        byte[] data = ChannelUtil.readAsBuffer(msg, dataLength); // 读取业务数据
        byte status = msg.readByte(); // 获取状态，1个字节
        byte checkSum = msg.readByte(); // 获取校验码，1个字节
        byte validate = MessageV2Util.getCheckSum(magic, packetLength, version, mac, messageId, data, status);
        if (validate != checkSum) {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("数据校验失败:{}, {}", messageId, addrInfo);
            }
            return;
        }
        Message message = new MessageV2(magic, packetLength, version, mac, messageId, data, status, checkSum);
        ChannelUtil.cacheChannel(message.getMacHex(), channel); // 缓存设备与通道
        ThreadLocalUtil.set(Message.class, message); // 线程缓存
        ByteBuf buf = ctx.alloc().buffer();
        try {
            ctx.fireChannelRead(buf.asReadOnly()); // 执行下一个管道链中的处理器
        } catch (Exception e) {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error(Tools.formatString("消息处理出错: {}", e.getMessage()), e);
            }
        } finally {
            ThreadLocalUtil.removeAll();
            buf.release(); // 释放消息容器空间
        }
    }
}
