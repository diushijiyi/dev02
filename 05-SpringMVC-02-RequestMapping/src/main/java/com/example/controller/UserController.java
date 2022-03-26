package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping(path = {"register1","register2","register3"})
    public void getParam(String name,Integer age){
        System.out.println(name+":"+age);
    }
}
