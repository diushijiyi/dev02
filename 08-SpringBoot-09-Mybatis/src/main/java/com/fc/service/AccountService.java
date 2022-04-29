package com.fc.service;

import org.springframework.data.relational.core.sql.In;

public interface AccountService {
//    转账
    void transferMoney(Integer from, Integer to, Integer money);
}
