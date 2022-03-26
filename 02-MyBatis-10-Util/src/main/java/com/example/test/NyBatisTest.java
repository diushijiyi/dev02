package com.example.test;

import com.example.dao.StudentDao;
import com.example.entity.Student;
import com.example.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class NyBatisTest {
    @Test
    public void test(){
        try {
            StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
            List<Student> students = studentDao.findAll();
            for (Student student : students) {
                System.out.println(student);
            }
            MyBatisUtil.commit();
        }catch (Exception e){
            MyBatisUtil.rollback();
            e.printStackTrace();
        }

    }
}
