package com.example.dao;

import com.example.entity.Student;

import java.util.List;

public interface StudentDao {
    Student findById();
    List<Student> findAll();
    Student findStudentById(Integer id);
}
