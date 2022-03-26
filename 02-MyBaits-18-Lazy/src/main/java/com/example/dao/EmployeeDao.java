package com.example.dao;

import com.example.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findById(@Param("id") Integer id);
}
