package com.example.dao;

import com.example.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {
    Department findById(@Param("id") Integer id);
}
