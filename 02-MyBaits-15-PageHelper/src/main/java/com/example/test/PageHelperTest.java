package com.example.test;


import com.example.dao.StudentDao;
import com.example.entity.Student;
import com.example.util.MyBatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;


public class PageHelperTest {
    @Test
    public void test(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        PageHelper.startPage(2,3);
        List<Student> students = studentDao.findAll();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        System.out.println(pageInfo);
        MyBatisUtil.commit();
    }
}
