package com.example.service.impl;

import com.example.dao.AccountDao;
import com.example.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    @Override
    public void transfer(Integer from, Integer to, Long money) {
        accountDao.decreaseMoney(from,money);
        int num=1/0;
        accountDao.increaseMoney(to,money);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
