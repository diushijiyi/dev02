package com.example.dao.impl;

import com.example.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void findAll() {
        System.out.println("使用Oracle数据库");
    }
}
