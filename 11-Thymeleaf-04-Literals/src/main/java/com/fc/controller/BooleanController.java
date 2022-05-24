package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class BooleanController {
    @RequestMapping("boolean")
    public String test(Model model){
        model.addAttribute("boolean",true);
        model.addAttribute("age",22);
        ArrayList<String> notes = new ArrayList<>();
        notes.add("抗疫日记");
        model.addAttribute("notes",notes);

        return "boolean";
    }
}
