package org.sj.iot.gateway.data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sj.iot.gateway.data.model.Groups;

import java.util.List;

@Mapper
public interface IGroupsDAO {
    List<Groups> listGroup();

    Groups getByPrimaryKey(Integer id);

    int insert(Groups record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(Groups record);
}