package org.sj.iot.gateway.data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sj.iot.gateway.data.model.Lights;

import java.util.List;

@Mapper
public interface ILightsDAO {
    List<Lights> listlight();

    Lights getByPrimaryKey(Integer uuid);

    int insert(Lights record);

    int deleteByPrimaryKey(Integer uuid);

    int updateByPrimaryKey(Lights record);
}