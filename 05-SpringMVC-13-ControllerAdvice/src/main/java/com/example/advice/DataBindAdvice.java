package com.example.advice;

import com.example.uti.CustomFormatter;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@ControllerAdvice
public class DataBindAdvice {
    @InitBinder
    public void parseDate(WebDataBinder binder){
        binder.addCustomFormatter(new CustomFormatter());
    }
    @InitBinder("student")
    public void bindStudent(WebDataBinder binder){
        binder.setFieldDefaultPrefix("student.");
    }
    @InitBinder("teacher")
    public void bindTeacher(WebDataBinder binder){
        binder.setFieldDefaultPrefix("teacher.");
    }
    @ModelAttribute("createDateTime")
    public Date getCreateDateTime(){
        System.out.println("Controller执行之前.....");
        return new Date();
    }
}
