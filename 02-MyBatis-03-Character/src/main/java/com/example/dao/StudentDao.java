package com.example.dao;

import com.example.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> findByLessThanAge(Integer age);
    List<Student> findGreaterThanAge(Integer age);

}
