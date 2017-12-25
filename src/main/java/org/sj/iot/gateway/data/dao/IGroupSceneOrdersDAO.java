package org.sj.iot.gateway.data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sj.iot.gateway.data.model.GroupSceneOrders;

@Mapper
public interface IGroupSceneOrdersDAO {
    /**
     * 插入分组关联关系
     */
    int insert(GroupSceneOrders record);

    /**
     * 删除指定分组与情景的关联关系
     */
    int deleteByGroupid(Integer groupid);

    /**
     * 修改指定分组的指定情景排序值
     */
    int updateOrderIndex(@Param("groupid") Integer groupid, @Param("sceneid") Integer sceneid, @Param("orderIndex") Integer orderIndex);
}