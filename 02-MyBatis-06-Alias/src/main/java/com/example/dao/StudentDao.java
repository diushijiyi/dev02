package com.example.dao;

import com.example.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    Student findById(Integer id);
    Student findByName(String name);
    Student findByAge(Byte age);
    Student findByGender(String gender);
}
