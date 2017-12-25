package org.sj.iot.gateway.connection.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 消息出站编码处理器
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-06
 */
@Sharable
@Component
public class MessageEncoder extends ChannelOutboundHandlerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageEncoder.class);

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        try {
            ctx.writeAndFlush(msg, promise);
        } catch (Exception e) {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("消息出站失败: {}", e.getMessage());
            }
        }
    }
}
