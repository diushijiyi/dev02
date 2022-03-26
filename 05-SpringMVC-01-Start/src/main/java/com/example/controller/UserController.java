package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("login")
    public String login(){
        System.out.println("login");
        return "/login.jsp";
    }
    @RequestMapping("add")
    public String add(){
        System.out.println("add");
        return "/success.jsp";
    }
    @RequestMapping("update")
    public String update(){
        System.out.println("update");
        return "/success.jsp";
    }
}
