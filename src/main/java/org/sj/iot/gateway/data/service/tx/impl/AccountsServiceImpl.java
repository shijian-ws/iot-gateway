package org.sj.iot.gateway.data.service.tx.impl;

import org.sj.iot.gateway.data.dao.IAccountsDAO;
import org.sj.iot.gateway.data.model.Accounts;
import org.sj.iot.gateway.data.service.tx.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-05
 */
@Service
public class AccountsServiceImpl implements IAccountsService {
    @Autowired
    private IAccountsDAO accountsDAO;

    @Override
    public Accounts get() {
        return accountsDAO.get();
    }

    @Override
    public void saveOrUpdate(Accounts record) {
        if (accountsDAO.count() == 0) {
            // 保存
            accountsDAO.insert(record);
            return;
        }
        accountsDAO.update(record);
    }
}
