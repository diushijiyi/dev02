package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NumController {
    @RequestMapping("num")
    public String text(Model model){
        model.addAttribute("num",100);

        return "num";
    }
}
