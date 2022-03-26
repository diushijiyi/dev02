package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.dao.impl.UserDaoMySQLImpl;
import com.example.dao.impl.UserDaoOracleImpl;
import com.example.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public void useDateBase() {
        userDao.useDateBase();
    }

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }
}
