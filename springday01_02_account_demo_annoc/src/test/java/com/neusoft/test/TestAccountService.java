package com.neusoft.test;
import com.neusoft.daomain.Account;
import com.neusoft.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class TestAccountService {
    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    IAccountService as = ac.getBean("accountService", IAccountService.class);
@Test
    public void testFindAll(){
    List<Account> allAccount = as.findAllAccount();
    for (Account account:allAccount) {
        System.out.println(account);
    }
}
@Test
    public void testFindById(){
    Account accountById = as.findAccountById(1);
    System.out.println(accountById);
}
    @Test
    public void testSaveAccount(){
        Account account = new Account();
        account.setId(4);
        account.setMoney(500.0f);
        account.setName("wangxijie");
        as.saveAccount(account);
        System.out.println(account);
    }
    @Test
    public void testDeleteAccount(){
        as.deleteAccount(6);

    }
    @Test
    public void testUpdateAccount(){



    }
}

