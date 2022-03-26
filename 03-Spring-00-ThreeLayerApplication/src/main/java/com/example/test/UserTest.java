package com.example.test;

import com.example.dao.impl.UserDaoImpl;
import com.example.dao.impl.UserDaoMySQLImpl;
import com.example.dao.impl.UserDaoOracleImpl;
import com.example.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserTest {
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoOracleImpl());
        userService.useDateBase();
    }
}
