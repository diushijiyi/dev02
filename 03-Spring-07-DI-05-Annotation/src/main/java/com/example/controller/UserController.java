package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public List<User> findAll(){
        return userService.findAll();
    }
}
