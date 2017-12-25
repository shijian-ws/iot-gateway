package org.sj.iot.gateway.data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sj.iot.gateway.data.model.Gatewayinfo;

@Mapper
public interface IGatewayinfoDAO {
    /**
     * 获取网关信息
     */
    Gatewayinfo get();

    /**
     * 查询网关信息数量
     */
    long count();

    /**
     * 插入网关信息
     */
    int insert(Gatewayinfo record);

    /**
     * 部分更新网关信息
     */
    int update(Gatewayinfo record);
}