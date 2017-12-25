package org.sj.iot.gateway.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 连接配置类
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-06
 */
@ConfigurationProperties(prefix = "connection")
public class ConnectionProperties {
    private Settings server;
    private Settings client;

    public Settings getServer() {
        return server;
    }

    public void setServer(Settings server) {
        this.server = server;
    }

    public Settings getClient() {
        return client;
    }

    public void setClient(Settings client) {
        this.client = client;
    }

    public static final class Settings {
        private String id; // 客户端标识
        private String host = "127.0.0.1"; // 服务器地址
        private Integer port; // 端口
        private Boolean ssl = false; // 默认关闭SSL
        private Long heartbeatTime = 30L; // 心跳包间隔时间
        private Long reconnectTime = 30L; // 重连间隔时间

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        public Boolean getSsl() {
            return ssl;
        }

        public void setSsl(Boolean ssl) {
            this.ssl = ssl;
        }

        public Long getHeartbeatTime() {
            return heartbeatTime;
        }

        public void setHeartbeatTime(Long heartbeatTime) {
            this.heartbeatTime = heartbeatTime;
        }

        public Long getReconnectTime() {
            return reconnectTime;
        }

        public void setReconnectTime(Long reconnectTime) {
            this.reconnectTime = reconnectTime;
        }
    }
}
