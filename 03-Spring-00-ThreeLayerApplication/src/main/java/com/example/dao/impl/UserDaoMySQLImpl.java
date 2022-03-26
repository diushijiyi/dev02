package com.example.dao.impl;

import com.example.dao.UserDao;

public class UserDaoMySQLImpl implements UserDao {
    @Override
    public void useDateBase() {
        System.out.println("使用MsSQL连接数据库");
    }
}
