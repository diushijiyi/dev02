package com.example.test;


import com.example.dao.AccountDao;
import com.example.entity.Account;
import com.example.entity.TAccount;
import com.example.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class ORMTest {
    @Test
    public void testCamelCase(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);
        List<TAccount> accounts = accountDao.findAllByCamelCase();
        for (TAccount account : accounts) {
            System.out.println(account);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void testMap() {
            AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);
            Account account = accountDao.findById(1);
            System.out.println(account);
            MyBatisUtil.commit();
    }
    @Test
    public void test(){
            AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);
            List<Account> accounts = accountDao.findAll();
            for (Account account : accounts) {
                System.out.println(account);
            }
            MyBatisUtil.commit();
    }
}
