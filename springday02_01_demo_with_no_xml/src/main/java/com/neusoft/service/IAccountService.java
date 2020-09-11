package com.neusoft.service;

import com.neusoft.daomain.Account;

import java.util.List;

public interface IAccountService {
    //查询所有
    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
