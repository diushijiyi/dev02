package com.example.dao.impl;

import com.example.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void useDateBase() {
        System.out.println("使用Oracle连接数据库");
    }
}
