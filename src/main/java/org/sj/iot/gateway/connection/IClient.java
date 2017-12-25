package org.sj.iot.gateway.connection;

/**
 * 客户端接口
 * 
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-06
 */
public interface IClient {
    /**
     * 设置客户端标识
     */
    void setId(String id);

    /**
     * 获取当前客户端标识
     */
    String getId();

    /**
     * 获取服务器地址
     */
    public String getHost();

    /**
     * 设置服务端地址
     */
    public void setHost(String host);

    /**
     * 设置监听端口
     */
    public void setPort(int port);

    /**
     * 获取服务端端口
     */
    public int getPort();

    /**
     * 设置是否开启SSL通信
     */
    public void setSsl(boolean open);

    /**
     * 是否开启SSL，默认:未开启,false
     */
    public boolean isSsl();

    /**
     * 启动客户端
     */
    public void start();

    /**
     * 客户端是否启动
     */
    public boolean isStart();

    /**
     * 关闭客户端
     */
    public void stop();

    /**
     * 客户端是否关闭
     */
    public boolean isStop();

    /**
     * 重启客户端
     */
    public void restart();

    /**
     * 启动时间
     */
    public long getStartTime();
}
