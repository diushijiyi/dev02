package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CxtController {
    @RequestMapping("cxt")
    public String test(Model model, HttpServletRequest request){
//        model.addAttribute("attr","model");
        request.setAttribute("attr","request");
        request.getSession().setAttribute("attr","session");
        request.getServletContext().setAttribute("attr","servletContext");


        return "cxt";
    }
}
