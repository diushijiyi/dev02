package com.fc.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

public interface TbUserService {
    ModelAndView login(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       Number remember);
}
