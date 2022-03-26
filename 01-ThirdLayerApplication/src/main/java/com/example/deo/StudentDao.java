package com.example.deo;

import com.example.entity.Student;

import java.util.List;

public interface StudentDao{

    int getTotalCount();

    List<Student> getList(int pageNo, int pageSize);
}
