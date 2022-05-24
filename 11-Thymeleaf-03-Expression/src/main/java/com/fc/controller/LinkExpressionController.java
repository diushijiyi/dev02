package com.fc.controller;

import com.fc.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class LinkExpressionController {
    @RequestMapping("test/link/test")
    public String testStandardExpression(Model model){
        return "link";
    }
    @RequestMapping("url")
    @ResponseBody
    public String testUrl(){
        return "绝对路径";
    }
    @RequestMapping("test/url")
    @ResponseBody
    public String testSuperUrl(){
        return "上级路径";
    }
    @RequestMapping("test/link/url")
    @ResponseBody
    public String testLinkUrl(){
        return "当前路径";
    }
}
