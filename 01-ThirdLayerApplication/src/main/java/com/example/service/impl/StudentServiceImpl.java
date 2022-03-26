package com.example.service.impl;

import com.example.deo.StudentDao;
import com.example.deo.impl.StudentDaoImpl;
import com.example.entity.Student;
import com.example.vo.PageInfo;
import com.example.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao=new StudentDaoImpl();
    @Override
    public PageInfo<Student> getPageInfo(int pageNo, int pageSize) {
        int totalCount=studentDao.getTotalCount();
        List<Student> list=studentDao.getList(pageNo,pageSize);

        return new PageInfo<>(totalCount,pageSize,pageNo,list);
    }
}
