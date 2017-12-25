package org.sj.iot.gateway.connection;

/**
 * TCP客户端端接口
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-05-26
 */
public interface ITcpClient extends IClient {
    /**
     * 获取安全套接字上下文对象
     */
    default <T> T getSSLContext() {
        return null;
    }
}
