package com.example.service;

import com.example.entity.Student;
import com.example.vo.PageInfo;

public interface StudentService {
    PageInfo<Student> getPageInfo(int pageNo, int pageSize);
}
