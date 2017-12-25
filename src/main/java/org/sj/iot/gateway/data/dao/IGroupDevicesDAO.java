package org.sj.iot.gateway.data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sj.iot.gateway.data.model.GroupDevices;

@Mapper
public interface IGroupDevicesDAO {

    int insert(GroupDevices record);

    int deleteByGroupid(Integer id);

    int deleteByMac(String mac);

    int update(GroupDevices record);
}