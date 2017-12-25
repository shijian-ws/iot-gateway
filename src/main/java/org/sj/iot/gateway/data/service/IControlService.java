package org.sj.iot.gateway.data.service;

import org.sj.iot.gateway.data.model.Accounts;
import org.sj.iot.gateway.data.model.Gatewayinfo;

/**
 * 命令业务操作接口
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-06
 */
public interface IControlService {
    /**
     * 获取网关设备信息
     */
    Gatewayinfo getgatewayinfo();

    /**
     * 获取绑定用户信息
     *
     * @return
     */
    Accounts getuserdata();

    /**
     * 打开, 关闭灯设备
     */
    void setlighton();

    /**
     * 设置灯设备颜色
     */
    void setlightcolor();
}
