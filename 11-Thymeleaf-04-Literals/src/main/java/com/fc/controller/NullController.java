package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NullController {
    @RequestMapping("null")
    public String test(Model model){
        model.addAttribute("value",null);
        model.addAttribute("string","");
        return "null";
    }
    @RequestMapping("null1")
    public ModelAndView test(ModelAndView mv){
        mv.addObject("value",null);
        mv.addObject("string","");
        mv.setViewName("null");
        return mv;
    }
}
