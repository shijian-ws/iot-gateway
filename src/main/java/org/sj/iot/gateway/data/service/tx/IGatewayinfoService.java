package org.sj.iot.gateway.data.service.tx;

import org.sj.iot.gateway.data.model.Gatewayinfo;

/**
 * 网关信息业务操作接口
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-05
 */
public interface IGatewayinfoService {
    /**
     * 获取当前网关信息
     */
    Gatewayinfo get();

    /**
     * 保存或更新网关信息
     */
    void saveOrUpdate(Gatewayinfo record);
}