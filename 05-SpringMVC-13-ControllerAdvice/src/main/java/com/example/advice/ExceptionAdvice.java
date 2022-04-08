package com.example.advice;

import com.example.exception.SingletonDogException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(SingletonDogException.class)
    @ResponseBody
    public Map<String,Object> handleSingletonDogException(Exception exception){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("message","路见不平一声吼，你还没有男朋友");
        map.put("success",false);
        map.put("data",exception.getMessage());
        return map;
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> handleException(Exception exception){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("message",exception.getMessage());
        map.put("success",false);
        map.put("data",exception.getMessage());
        return map;
    }
}
