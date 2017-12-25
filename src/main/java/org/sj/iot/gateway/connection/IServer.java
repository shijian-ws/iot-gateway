package org.sj.iot.gateway.connection;

/**
 * 服务端接口
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-06
 */
public interface IServer {
    /**
     * 设置监听端口
     */
    public void setPort(int port);

    /**
     * 获取监听端口
     */
    public int getPort();

    /**
     * 开启SSL通信
     */
    public void setSsl(boolean open);

    /**
     * 是否开启SSL，默认:未开启,false
     */
    public boolean isSsl();

    /**
     * 启动服务端, 单线程阻塞等待服务端关闭
     */
    public void start();

    /**
     * 关闭服务端
     */
    public void stop();

    /**
     * 服务端是否关闭
     */
    public boolean isStop();

    /**
     * 重启服务端, 异步启动
     */
    public void restart();

    /**
     * 启动时间
     */
    public long getStartTime();
}
