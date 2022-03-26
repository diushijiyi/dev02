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
    public void testGetIncrement(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student=new Student();
            student.setName("狂拽酷炫霸");
            student.setAge((byte)2);
            student.setGender("男");
            student.setInfo("真拽");
            int affectedRows = studentDao.getIncrement(student);
            System.out.println("受影响的行数："+affectedRows);
            System.out.println("获取自增长id:"+student.getId());
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindByKeyword(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students = studentDao.findByKeyword("%王%");
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
    public void testFindById(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student students = studentDao.findById(1);
            System.out.println(students);
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
            List<Student> students = studentDao.findAll();
            for (Student student:students) {
                System.out.println(student);
            }
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testUpdate(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student=new Student();
            student.setInfo("睡砸");
            student.setId(3);
            int affectedRows = studentDao.update(student);
            System.out.println("受影响的行数："+affectedRows);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDelete(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            int affectedRows = studentDao.delete(2);
            System.out.println("受影响的行数："+affectedRows);
            session.commit();
            session.close();
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
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student=new Student();
            student.setName("王婷婷");
            student.setAge((byte)20);
            student.setGender("女");
            student.setInfo("真好看");
            int affectedRows = studentDao.insert(student);
            System.out.println("受影响的行数："+affectedRows);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
