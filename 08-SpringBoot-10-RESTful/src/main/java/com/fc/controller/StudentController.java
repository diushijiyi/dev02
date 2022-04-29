package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }
    @PostMapping("{name}/{age}/{gender}/{info}")
    public Integer insert(Student student){
        return studentService.insert(student);
    }
    @PutMapping("{id}/{info}")
    public Integer update(@PathVariable("id") Integer id,
                          @PathVariable("info") String info){
        return studentService.update(id, info);
    }
    @DeleteMapping("{id}")
    public Integer delete(@PathVariable("id") Integer id){
        return studentService.delete(id);
    }



}
