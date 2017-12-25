package org.sj.iot.gateway.connection.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.sj.iot.gateway.connection.util.ChannelUtil;
import org.sj.iot.model.DataBody;
import org.sj.iot.model.Message;
import org.sj.iot.util.MessageV2Util;
import org.sj.iot.util.ProcessUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 心跳包处理器
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-17
 */
@Sharable
@Component
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(HeartBeatHandler.class);
    private static final Map<Channel, AtomicBoolean> cacheSendHB = new ConcurrentHashMap<>();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        cacheSendHB.put(channel, new AtomicBoolean(false)); // 缓存通道心跳检测标识
        channel.closeFuture().addListener(future -> cacheSendHB.remove(channel)); // 移除通道心跳检测标识
        super.channelActive(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (IdleState.ALL_IDLE.equals(event.state()) || IdleState.READER_IDLE.equals(event.state())) {
                // 通道一定时间没有接收到服务端数据, 准备发送心跳包
                Channel channel = ctx.channel();
                AtomicBoolean flag = cacheSendHB.get(channel);
                if (flag.get() == true) {
                    // 未响应
                    channel.close();
                    return;
                }
                String mac = ChannelUtil.getMac(channel); // 获取通道对应MAC
                byte messageId = MessageV2Util.createMessageId(mac); // 创建消息id
                Runtime runtime = Runtime.getRuntime();
                Long totalMemory = runtime.totalMemory();
                Long freeMemory = runtime.freeMemory();
                // 创建心跳包格式云端消息
                DataBody body = DataBody.createCloudMessageByHb(totalMemory, freeMemory, null, null);
                // 创建TCP协议栈格式消息
                Message request = MessageV2Util.createMessage(mac, messageId, body);
                ProcessUtil.set(mac, messageId, result -> {
                    if (LOGGER.isDebugEnabled()) {
                        LOGGER.debug("心跳包, 服务器端响应: {}", result);
                    }
                    flag.set(false); // 收到响应, 标记未发送
                });
                flag.set(true); // 标记已发送
                ChannelUtil.writeMessage(ctx, request);
            }
        }
    }
}