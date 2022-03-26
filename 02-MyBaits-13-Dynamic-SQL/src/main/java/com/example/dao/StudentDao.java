package com.example.dao;

import com.example.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.net.Inet4Address;
import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    List<Student> findByKeyword(@Param("name") String name,@Param("age") Integer age);
    List<Student> findByStudent(Student student);
    int update(Student student);
    int updateWithTrim(Student student);
    List<Student> findByStudentWithTrim(Student student);
    int deleteMore(Integer... ids);
}
