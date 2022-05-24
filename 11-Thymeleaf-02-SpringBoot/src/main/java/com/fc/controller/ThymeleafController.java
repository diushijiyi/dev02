package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
    @RequestMapping("test")
    public String test(HttpServletRequest request){
        request.setAttribute("data","请求域对象设置参数到Thymeleaf中");
        return "index";
    }
    @RequestMapping("test1")
    public ModelAndView test1(ModelAndView mv){
        mv.addObject("data","ModelAndView设置参数到Thymeleaf中");
        mv.setViewName("index");
        return mv;
    }
    @RequestMapping("test2")
    public String test2(Model model){
        model.addAttribute("data","Model设置参数到Thymeleaf中");
        return "index";
    }
}
