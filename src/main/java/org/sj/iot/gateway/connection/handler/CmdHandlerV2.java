package org.sj.iot.gateway.connection.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.sj.iot.gateway.connection.util.ChannelUtil;
import org.sj.iot.gateway.data.service.IControlService;
import org.sj.iot.model.Cmd;
import org.sj.iot.model.DataBody;
import org.sj.iot.model.Message;
import org.sj.iot.util.JsonUtil;
import org.sj.iot.util.MessageV2Util;
import org.sj.iot.util.ThreadLocalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 命令处理器v2版本
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-14
 */
@Sharable
@Component
public class CmdHandlerV2 extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CmdHandlerV2.class);

    @Autowired
    private IControlService controlService;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = ThreadLocalUtil.get(Message.class); // MessageV2Util.read((ByteBuf) msg); // 从容器中读取消息对象
        DataBody body = message.getDataBody();
        String type = body.getType();
        if (!DataBody.REMOTE_CONTROL.equals(type)) {
            // 非远程控制, 放行
            ctx.fireChannelRead(msg);
            return;
        }
        Cmd.CmdInfo cmdInfo = body.getCmd();
        String mac = message.getMacHex();
        byte messageId = message.getMessageId();
        // 处理云端或App请求
        int result = 0; // 响应结果状态码
        String errormsg = "ok"; // 响应消息
        String response = null; // 响应数据
        String cmdName = cmdInfo.getCmdName();
        Method method = BeanUtils.findMethod(IControlService.class, cmdName); // 获取对应命令控制业务接口的方法
        if (method == null) {
            // 不支持的命令
            result = 3;
            errormsg = "cmd unsupport";
        } else {
            try {
                Object resp = method.invoke(controlService); // 执行方法
                if (resp != null) {
                    if (resp instanceof String) {
                        response = (String) resp;
                    } else if (resp instanceof byte[]) {
                        response = new String((byte[]) resp);
                    } else {
                        response = JsonUtil.toJsonString(resp);
                    }
                } else {
                    if (method.getReturnType() != void.class) {
                        // 存在返回类型但返回值为null
                        response = "{}";
                    }
                }
            } catch (Exception e) {
                result = 1;
                errormsg = e.getMessage();
                if (LOGGER.isErrorEnabled()) {
                    LOGGER.error("处理命令[{}]失败: {}", message, e.getMessage());
                }
            }
        }
        // 创建应答对象
        Cmd.AckInfo ackInfo = Cmd.createAckInfo(cmdInfo, result, errormsg, response);
        // 创建响应消息数据对象
        DataBody respBody = new DataBody(ackInfo);
        // 创建tcp消息对象
        Message resp = MessageV2Util.createMessage(mac, messageId, JsonUtil.toJsonString(respBody));
        // 消息响应
        ChannelUtil.writeMessage(ctx, resp);
    }
}
