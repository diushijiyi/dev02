package com.example.dao;

import com.example.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findByAge(String age);
    List<Student> findById(String age);
}
