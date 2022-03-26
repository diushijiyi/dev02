package com.example.test;

import com.example.dao.StudentDao;
import com.example.entity.Student;
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
    public void testfindAll(){
        SqlSession session=null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students = studentDao.findAll();
            for (Student student : students) {
                System.out.println(student);
            }
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }

    }

}
