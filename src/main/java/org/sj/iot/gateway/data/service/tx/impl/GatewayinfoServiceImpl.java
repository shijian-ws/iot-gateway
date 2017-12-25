package org.sj.iot.gateway.data.service.tx.impl;

import org.sj.iot.gateway.data.dao.IGatewayinfoDAO;
import org.sj.iot.gateway.data.model.Gatewayinfo;
import org.sj.iot.gateway.data.service.tx.IGatewayinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-05
 */
@Service
public class GatewayinfoServiceImpl implements IGatewayinfoService {
    @Autowired
    private IGatewayinfoDAO gatewayinfoDAO;

    @Override
    public Gatewayinfo get() {
        return gatewayinfoDAO.get();
    }

    @Override
    public void saveOrUpdate(Gatewayinfo record) {
        if (gatewayinfoDAO.count() == 0) {
            gatewayinfoDAO.insert(record);
            return;
        }
        gatewayinfoDAO.update(record);
    }
}

