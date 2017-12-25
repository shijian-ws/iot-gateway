package org.sj.iot.gateway.connection.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.sj.iot.model.DataBody;
import org.sj.iot.model.Message;
import org.sj.iot.model.MessageV2;
import org.sj.iot.util.ThreadLocalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 扩展任务处理器
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-18
 */
@Sharable
@Component
public class ExtHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExtHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = ThreadLocalUtil.get(Message.class); // MessageV2Util.read((ByteBuf) msg); // 从容器中读取消息对象
        DataBody body = message.getDataBody();
        String type = body.getType();
        if ("".equals(type)) {

        }
        // 非任务回调处理, 放行
        ctx.fireChannelRead(msg);
    }
}
