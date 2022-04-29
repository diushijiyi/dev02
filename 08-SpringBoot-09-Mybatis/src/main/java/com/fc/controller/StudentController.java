package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("findAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }
    @RequestMapping("findByPage")
    public PageInfo<Student> findByPage(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = studentService.findAll();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }
}
