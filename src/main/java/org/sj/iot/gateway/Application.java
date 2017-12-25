package org.sj.iot.gateway;

import org.sj.iot.gateway.configuration.ConnectionProperties;
import org.sj.iot.gateway.connection.ITcpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

/**
 * 网关设备启动类
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-04
 */
@SpringBootApplication
@EnableConfigurationProperties(ConnectionProperties.class)
public class Application {
    public static void main(String[] args) {
        ApplicationContext content = SpringApplication.run(Application.class, args);
        ITcpClient tcpClient = content.getBean(ITcpClient.class);
        tcpClient.start();
    }
}
