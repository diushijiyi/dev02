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
    public void testFindStudentById(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findStudentById(2);
            System.out.println(student);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindAll(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students=studentDao.findAll();
            for (Student student : students) {
                System.out.println(student);
            }
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testInterface(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findById();
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testInsert(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            int affectedRows = session.insert("StudentMapper.insert");
            System.out.println("受影响的行数："+affectedRows);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        try {
            InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession=sqlSessionFactory.openSession();
            Object o = sqlSession.selectOne("StudentMapper.select");
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
