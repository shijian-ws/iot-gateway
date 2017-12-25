package org.sj.iot.gateway.data.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sj.iot.gateway.data.model.Accounts;

@Mapper
public interface IAccountsDAO {
    /**
     * 获取账号信息
     */
    Accounts get();

    /**
     * 获取账号信息记录数
     */
    long count();

    /**
     * 插入账号信息
     */
    int insert(Accounts record);

    /**
     * 更新账号信息
     */
    int update(Accounts record);
}