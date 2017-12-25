package org.sj.iot.gateway.data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sj.iot.gateway.data.model.SwitchKeys;
import org.sj.iot.gateway.data.model.Switchs;

import java.util.List;

@Mapper
public interface ISwitchsDAO {
    List<Switchs> listSwitch();

    Switchs getByMac(String mac);

    int insert(Switchs record);

    int deleteByMac(String mac);

    int updateByMac(Switchs record);

    List<SwitchKeys> listSwitchKeyByMac(String mac);

    SwitchKeys getSwitchKeyByMac(@Param("mac") String mac, @Param("key") Integer key);

    int insertSwitchKey(SwitchKeys record);

    int deleteSwitchKeyByMac(String mac);

    int updateSwitchKeyByMac(SwitchKeys record);
}