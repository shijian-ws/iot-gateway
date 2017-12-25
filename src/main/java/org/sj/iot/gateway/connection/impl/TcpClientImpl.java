package org.sj.iot.gateway.connection.impl;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.IdleStateHandler;
import org.sj.iot.gateway.configuration.ConnectionProperties;
import org.sj.iot.gateway.connection.ITcpClient;
import org.sj.iot.gateway.connection.handler.*;
import org.sj.iot.gateway.connection.util.ChannelUtil;
import org.sj.iot.gateway.data.model.Gatewayinfo;
import org.sj.iot.gateway.data.service.tx.IGatewayinfoService;
import org.sj.iot.util.Constants;
import org.sj.iot.util.MessageV2Util;
import org.sj.iot.util.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLEngine;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * 客户端实现
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-06
 */
@Component
public class TcpClientImpl extends AbstractImpl implements ITcpClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(TcpClientImpl.class);

    private SslContext sslContext;

    @Autowired
    private Bootstrap client;

    @Autowired
    private HeartBeatHandler heartBeatHandler;
    @Autowired
    private MessageEncoder messageEncoder;
    @Autowired
    private CloudMessageDecoderV2 cloudMessageDecoder;
    @Autowired
    private ProcessHandler processHandler;
    @Autowired
    private CmdHandlerV2 cmdHandler;

    @Autowired
    private ConnectionProperties properties;

    @Autowired
    private IGatewayinfoService gatewayinfoService;

    private long heartbeatTime = 30L; // 心跳包间隔时间
    private long reconnectTime = 30L; // 重连间隔时间

    /**
     * 加载配置参数
     */
    private void initProperties() {
        Gatewayinfo gatewayinfo = gatewayinfoService.get();
        if (gatewayinfo != null) {
            String mac = gatewayinfo.getMac();
            String serverip = gatewayinfo.getServerip();
            Integer serverport = gatewayinfo.getServerport();
            if (mac != null) {
                this.setId(mac);
            }
            if (serverip != null) {
                this.setHost(serverip);
            }
            if (serverport != null) {
                this.setPort(serverport);
            }
        }
        ConnectionProperties.Settings clientProps = properties.getClient();
        String id = clientProps.getId();
        if (id != null) {
            this.setId(id);
        }
        if (getId() == null) {
            String mac = Tools.toHex(Tools.getRandom().nextLong(), 6).toUpperCase();
            this.setId(mac);
            LOGGER.warn("未指定客户端MAC, 随机生成: {}", mac);
        }
        String host = clientProps.getHost();
        if (host != null) {
            this.setHost(host);
        }
        Integer port = clientProps.getPort();
        if (port != null) {
            this.setPort(port);
        }
        Boolean ssl = clientProps.getSsl();
        if (ssl != null) {
            this.setSsl(ssl);
        }
        Long reconnectTime = clientProps.getReconnectTime();
        if (reconnectTime != null) {
            this.reconnectTime = reconnectTime;
        }
        Long heartbeatTime = clientProps.getHeartbeatTime();
        if (heartbeatTime != null) {
            this.heartbeatTime = heartbeatTime;
        }
    }

    /**
     * 加载SSL
     */
    private void initSslContent() {
        if (super.isSsl() && sslContext == null) {
            // 开启SSL通信
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("初始化Netty客户端SSL上下文环境!");
            }
            ClassLoader classLoader = this.getClass().getClassLoader();
            try (InputStream key = classLoader.getResourceAsStream("client.pem"); // 私钥
                 InputStream cert = classLoader.getResourceAsStream("client.crt")) { // 证书
                sslContext = SslContextBuilder.forClient().keyManager(cert, key)/*.trustManager(new SimpleTrustManagerFactory() {
                    @Override
                    protected void engineInit(KeyStore keyStore) throws Exception {}
                    @Override
                    protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception {}
                    @Override
                    protected TrustManager[] engineGetTrustManagers() {
                        return new TrustManager[]{new X509TrustManager() {
                            @Override
                            public void checkClientTrusted(X509Certificate[] chain, String s) {}

                            @Override
                            public void checkServerTrusted(X509Certificate[] chain, String s) {
                                // 校验服务端证书合法性
                                System.out.println(s);
                            }

                            @Override
                            public X509Certificate[] getAcceptedIssuers() { return null; }
                        }};
                    }
                })*/.trustManager(InsecureTrustManagerFactory.INSTANCE).build();
            } catch (Exception e) {
                throw new IllegalArgumentException("初始化SSLContent失败: " + e.getMessage(), e);
            }
        }
    }

    @PostConstruct
    public void init() {
        initProperties();
        initSslContent();
        this.client.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                String mac = getId();

                ChannelUtil.cacheChannel(mac, ch); // 缓存通道

                // 添加通道关闭监听器
                ch.closeFuture().addListener(future -> {
                    if (!isStop()) {
                        if (LOGGER.isDebugEnabled()) {
                            LOGGER.warn("客户端[{}]通道断开, {}秒后重连! ", mac, reconnectTime);
                        }
                        ChannelUtil.removeChannel(mac); // 移除通道
                        MessageV2Util.clearMessageId(mac); // 移除消息id缓存
                        ch.eventLoop().schedule(() -> {
                            try {
                                client.connect(getHost(), getPort()).sync();
                                if (LOGGER.isDebugEnabled()) {
                                    LOGGER.info("客户端[{}]重连成功! ", mac);
                                }
                            } catch (Exception e) {
                                if (LOGGER.isDebugEnabled()) {
                                    LOGGER.error("客户端[{}]重连失败: {} ", mac, e.getMessage());
                                }
                            }
                        }, reconnectTime, TimeUnit.SECONDS); // 注册重连任务, 当前通道该任务只会被执行一次
                        return;
                    }
                    if (LOGGER.isDebugEnabled()) {
                        LOGGER.debug("客户端[{}]被关闭! ", mac);
                    }
                });

                ChannelPipeline pipeline = ch.pipeline();
                // 注册消息出站处理器 end 8
                pipeline.addLast(messageEncoder);

                // 注册日志处理器 start 1
                pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));

                SslContext sslContext = TcpClientImpl.this.sslContext;
                if (isSsl() && sslContext != null) {
                    // SSL引擎
                    SSLEngine engine = sslContext.newEngine(ch.alloc());
                    engine.setEnabledProtocols(new String[]{"TLSv1.2"});
                    // 注册SSL处理器 2
                    pipeline.addLast(new SslHandler(engine));
                }

                pipeline
                        // 注册空闲时间监听器 3
                        .addLast(new IdleStateHandler(0, 0, (int) heartbeatTime))
                        // 注册心跳包处理器 4
                        .addLast(heartBeatHandler)
                        // 注册TCP粘包/拆包处理器 5
                        .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, Constants.V2.MAGIC_NUMBER_LEN, Constants.V2.PACKET_LEN, 0, 0))
                        // 注册云端消息入站处理器 6
                        .addLast(cloudMessageDecoder)
                        // 注册任务回调处理器 7
                        .addLast(processHandler)
                        // 远程控制命令处理器 8
                        .addLast(cmdHandler);
            }
        });
    }

    @Override
    public void start() {
        String id = getId();
        String host = getHost();
        int port = getPort();
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("启动网关连接远程云端模块: {}->{}:{}[ssl:{}]", id, host, port, isSsl());
        }
        try {
            this.client.connect(host, port).sync(); // 同步等待连接远程服务端
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("网关连接远程云端模块启动成功! ");
            }
        } catch (Exception e) {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("网关连接远程云端模块启动失败: {}", e.getMessage());
            }
        }
    }

    @Override
    public void stop() {
        setStop(true);
        ChannelUtil.clearChannel();
    }

    @Override
    public void restart() {
        ChannelUtil.clearChannel();
        // throw new IllegalStateException("不支持操作! ");
    }

    @Override
    public <T> T getSSLContext() {
        return (T) sslContext;
    }

}
