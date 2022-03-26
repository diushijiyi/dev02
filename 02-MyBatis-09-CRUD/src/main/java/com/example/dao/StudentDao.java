package com.example.dao;

import com.example.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    int insert(Student student);
    int delete(@Param("id") Integer id);
    int update(Student student);
    List<Student> findAll();
    Student findById(@Param("id") Integer id);
    List<Student> findByKeyword(@Param("keyword") String keyword);
    int getIncrement(Student student);
}
