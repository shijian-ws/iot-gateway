package org.sj.iot.gateway.connection.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.sj.iot.model.Message;
import org.sj.iot.model.MessageV2;
import org.sj.iot.util.Constants;
import org.sj.iot.util.MessageV2Util;
import org.sj.iot.util.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 通道工具类
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-07
 */
public class ChannelUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelUtil.class);

    /**
     * 缓存通道，key=MAC,value=Channel
     */
    private static final Map<String, Channel> cacheChannel = new ConcurrentHashMap<>();

    /**
     * 清除所有客户端通道
     */
    public static void clearChannel() {
        synchronized (cacheChannel) {
            // 关闭通道
            cacheChannel.values().parallelStream().filter(Objects::nonNull).filter(Channel::isActive).forEach(Channel::close);
            cacheChannel.clear();
        }
    }

    /**
     * 清除客户端通道
     */
    public static boolean removeChannel(String mac) {
        Channel channel = cacheChannel.remove(mac);
        if (channel != null) {
            /*if (channel.isActive()) {
                channel.close(); // 关闭激活中的通道
            }*/ // 因为只有在关闭时才移除所以注释代码不会执行
            return true;
        }
        return false;
    }

    /**
     * 移除缓存客户端通道
     */
    public static String removeChannel(Channel channel) {
        String mac = null;
        for (Entry<String, Channel> en : cacheChannel.entrySet()) {
            if (en.getValue() == channel) {
                mac = en.getKey();
                break;
            }
        }
        if (mac != null) {
            cacheChannel.remove(mac);
        }
        return mac;
    }

    /**
     * 获取客户端通道数量
     */
    public static int getChannelSize() {
        return cacheChannel.size();
    }

    /**
     * 将设备与通道映射
     */
    public static void cacheChannel(String mac, Channel channel) {
        if (mac == null) {
            throw new IllegalArgumentException("缓存通道时未找到设备MAC地址!");
        }
        Channel old = cacheChannel.put(mac, channel);
        if (old != null && old != channel && old.isActive()) {
            old.close();
        }
    }

    /**
     * 获取通道所属设备的MAC地址
     */
    public static Channel getChannel(String mac) {
        return cacheChannel.get(mac);
    }

    /**
     * 根据通道获取MAC
     */
    public static String getMac(Channel channel) {
        for (Entry<String, Channel> en : cacheChannel.entrySet()) {
            if (en.getValue().equals(channel)) {
                return en.getKey();
            }
        }
        return null;
    }

    /**
     * 从容器中读取指定字节的数据
     */
    public static byte[] readAsBuffer(ByteBuf buf, int length) {
        byte[] buffer = new byte[length];
        try {
            buf.readBytes(buffer);
            return buffer;
        } catch (Exception e) {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("从容器读取数据失败: {}", e.getMessage());
            }
            throw e;
        }
    }

    /**
     * 从容器中读取一个Message对象并将容器的读索引还原
     */
    public static MessageV2 read(ByteBuf buf) {
        if (buf != null && buf.isReadable()) {
            int readerIndex = buf.readerIndex();
            int len = buf.readableBytes();
            byte[] data = new byte[len];
            try {
                buf.readBytes(data);
                return MessageV2Util.byteToMessage(data);
            } catch (Exception e) {
                if (LOGGER.isErrorEnabled()) {
                    LOGGER.error(Tools.formatString("从容器读取Message对象失败: {}", e.getMessage()), e);
                }
            } finally {
                buf.readerIndex(readerIndex);
            }
        }
        return null;
    }

    private static void writeAndFlush(ChannelHandlerContext ctx, ByteBuf buf) {
        try {
            ctx.writeAndFlush(buf); // 将数据发送到远程，消息出站
        } catch (Exception e) {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("消息出站失败: {}", e.getMessage());
            }
            throw new RuntimeException("消息出站失败!", e);
        }
    }

    /**
     * 发送数据
     */
    public static void writeMessage(ChannelHandlerContext ctx, String data) {
        Objects.requireNonNull(ctx, "通道不能为空!");
        if (!ctx.channel().isActive()) {
            throw new IllegalStateException("通道已被关闭，无法发送数据!");
        }
        if (data == null) {
            data = "";
        }
        ByteBuf buf = ctx.alloc().buffer(); // 获取消息容器
        buf.writeCharSequence(data, Constants.UTF8_CHARSET);
        writeAndFlush(ctx, buf);
    }

    private static void writeTo(ByteBuf buffer, Message message) {
        buffer.writeInt(message.getMagic()); // 写入魔数, 4字节
        buffer.writeInt(message.getPacketLength()); // 写入包长度, 4字节
        buffer.writeByte(message.getVersion()); // 写入版本, 2字节
        long mac = message.getMac();
        // 写入mac地址,6字节
        for (int i = Constants.V2.MAC_LEN - 1; i >= 0; i--) {
            buffer.writeByte((byte) (mac >>> (i * 8) & 0xFF));
        }
        buffer.writeByte(message.getMessageId()); // 写入消息ID, 1字节
        buffer.writeBytes(message.getData()); // 写入数据
        buffer.writeByte(message.getStatus()); // 写入状态, 1字节
        buffer.writeByte(message.getCheckSum()); // 写入校验码, 1字节
    }

    /**
     * 发送数据
     */
    public static void writeMessage(ChannelHandlerContext ctx, Message message) {
        Objects.requireNonNull(ctx, "通道不能为空!!");
        Objects.requireNonNull(message, "请求消息不能为空!!");
        if (!ctx.channel().isActive()) {
            throw new IllegalStateException("通道已被关闭，无法发送数据!");
        }
        ByteBuf buf = ctx.alloc().buffer(); // 获取消息容器
        writeTo(buf, message);
        writeAndFlush(ctx, buf);
        LOGGER.debug("消息出站: {}", message.getDataBody());
    }

    /**
     * 发送数据
     */
    public static void writeMessage(Channel channel, Message message) {
        Objects.requireNonNull(channel, "通道不能为空!!");
        Objects.requireNonNull(message, "请求消息不能为空!!");
        if (!channel.isActive()) {
            throw new IllegalStateException("通道已被关闭，无法发送数据!");
        }
        ByteBuf buf = channel.alloc().buffer(); // 获取消息容器
        writeTo(buf, message);
        try {
            synchronized (channel) {
                // 多命令时候须按照顺序写入
                channel.writeAndFlush(buf); // 将数据发送到远程，消息出站
            }
        } catch (Exception e) {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("消息出站失败: {}", e.getMessage());
            }
            throw new RuntimeException("消息出站失败!", e);
        }
    }
}
