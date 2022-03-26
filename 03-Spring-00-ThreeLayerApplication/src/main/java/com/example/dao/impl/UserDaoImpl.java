package com.example.dao.impl;

import com.example.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void useDateBase() {
        System.out.println("连接数据库");
    }
}
