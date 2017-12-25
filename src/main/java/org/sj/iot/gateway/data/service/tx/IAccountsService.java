package org.sj.iot.gateway.data.service.tx;

import org.sj.iot.gateway.data.model.Accounts;

/**
 * 账号业务操作接口
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-05
 */
public interface IAccountsService {
    /**
     * 获取当前账号信息
     */
    Accounts get();

    /**
     * 保存或更新账号信息
     */
    void saveOrUpdate(Accounts record);
}