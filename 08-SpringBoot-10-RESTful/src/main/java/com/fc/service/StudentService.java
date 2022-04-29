package com.fc.service;

import com.fc.entity.Student;
import org.apache.catalina.User;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    int insert(Student student);
    int update(Integer id,String info);
    int delete(Integer id);
}
