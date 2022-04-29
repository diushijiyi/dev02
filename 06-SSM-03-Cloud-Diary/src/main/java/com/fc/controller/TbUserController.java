package com.fc.controller;

import com.fc.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class TbUserController {
    @Autowired
    private TbUserService tbUserService;
    @PostMapping("login")
    private ModelAndView login(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Number remember){
        return tbUserService.login(username,password,remember);
    }
}
