package org.sj.iot.gateway.data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sj.iot.gateway.data.model.SceneLights;

@Mapper
public interface ISceneLightsDAO {
    int insert(SceneLights record);

    /**
     * 删除指定情景与灯设备关联关系
     */
    int deleteBySceneid(Integer sceneid);

    /**
     * 更新指定情景下指定灯设备信息
     */
    int update(SceneLights record);
}