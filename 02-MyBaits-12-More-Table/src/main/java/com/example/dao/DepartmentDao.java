package com.example.dao;

import com.example.entity.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> findAll();
}
