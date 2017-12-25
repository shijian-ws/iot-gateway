package org.sj.iot.gateway.data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sj.iot.gateway.data.model.Scenes;

import java.util.List;

@Mapper
public interface IScenesDAO {
    List<Scenes> listScene(Integer id);

    Scenes getByPrimaryKey(Integer id);

    int insert(Scenes record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(Scenes record);
}