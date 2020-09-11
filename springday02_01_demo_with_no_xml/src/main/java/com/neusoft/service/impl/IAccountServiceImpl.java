package com.neusoft.service.impl;

import com.neusoft.dao.IAccountDao;
import com.neusoft.dao.Impl.IAccountDaoImpl;
import com.neusoft.daomain.Account;
import com.neusoft.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("accountService")
public class IAccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;


    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public  Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }


    @Override
    public void saveAccount(Account account) {
accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
accountDao.deleteAccount(accountId);
    }
}
