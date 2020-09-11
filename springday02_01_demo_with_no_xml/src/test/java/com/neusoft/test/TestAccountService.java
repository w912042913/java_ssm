package com.neusoft.test;
import com.neusoft.config.SpringConfiguration;
import com.neusoft.daomain.Account;
import com.neusoft.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//使用注解的方法加载Junit单元测试
//spring整理junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)


public class TestAccountService {
//    注入注解
    @Autowired
    private IAccountService as=null;
@Test
    public void testFindAll(){
    List<Account> allAccount = as.findAllAccount();
    for (Account account:allAccount) {
        System.out.println(account);
    }
}
//@Test
//    public void testFindById(){
//    Account accountById = as.findAccountById(1);
//    System.out.println(accountById);
//}
//    @Test
//    public void testSaveAccount(){
//        Account account = new Account();
//        account.setId(4);
//        account.setMoney(500.0f);
//        account.setName("wangxijie");
//        as.saveAccount(account);
//        System.out.println(account);
//    }
//    @Test
//    public void testDeleteAccount(){
//        as.deleteAccount(6);
//
//    }
//    @Test
//    public void testUpdateAccount(){
//
//
//
//    }
}

