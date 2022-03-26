package com.example.dao;

import com.example.entity.Account;
import com.example.entity.TAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
    Account findById(@Param("id") Integer id);

    List<TAccount> findAllByCamelCase();
}
