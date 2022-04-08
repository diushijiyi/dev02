package com.example.controller;

import com.example.entity.Student;
import com.example.entity.Teacher;
import com.example.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("data")
public class DataController {
    @RequestMapping("getDate")
    public void getDate(Date date){
        System.out.println(date);
    }
    @RequestMapping("getName")
    @ResponseBody
    public Map<String,Object> getName(Student student, Teacher teacher){
        Map<String, Object> map = new HashMap<>();
        map.put("student",student);
        map.put("teacher",teacher);
        return map;
    }
    @RequestMapping("getCreateDateTime")
    @ResponseBody
    public Map<String,Object> getCreateDateTime(User user,@ModelAttribute("createDateTime") Date createTime){
        Map<String, Object> map = new HashMap<>();
        user.setCreateDateTime(createTime);
        map.put("user",user);
        return map;
    }
}
