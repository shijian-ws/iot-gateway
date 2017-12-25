package org.sj.iot.gateway.data.service.tx.impl;

import org.sj.iot.gateway.data.dao.IGroupsDAO;
import org.sj.iot.gateway.data.model.Lights;
import org.sj.iot.gateway.data.service.tx.IGroupsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-06
 */
public class GroupsServiceImpl implements IGroupsService {
    @Autowired
    private IGroupsDAO groupsDAO;

    @Override
    public List<Lights> listlight() {
        return null;
    }
}
