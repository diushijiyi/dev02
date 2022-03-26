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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NyBatisTest {
    @Test
    public void testInsertOnObject(){
        SqlSession session=null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            session= factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student=new Student();
            student.setName("鞠婧祎");
            student.setAge((byte)27);
            student.setGender("女");
            student.setInfo("四千年第一美女");
            int affectedRows=studentDao.insertStudent(student);
            System.out.println("受影响的行数："+affectedRows);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
    @Test
    public void testInsert(){
        SqlSession session=null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            session= factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Map<String,Object> map=new HashMap<>();
            map.put("name", "铠甲勇士");
            map.put("age", 20);
            map.put("gender", "男");
            map.put("info", "地虎侠，话费侠");
            int affectedRows=studentDao.insert(map);
            System.out.println("受影响的行数："+affectedRows);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
    @Test
    public void testFindByGenderAndName(){
        SqlSession session=null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            session= factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findByGenderAndName("女","王钰");
            System.out.println(student);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
    @Test
    public void testFindByAgeAndName(){
        SqlSession session=null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            session= factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findByAgeAndName(21,"王钰");
            System.out.println(student);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
   @Test
    public void test(){
       SqlSession session=null;
       try {
           InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
           SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            session= factory.openSession();
           StudentDao studentDao = session.getMapper(StudentDao.class);
           Student student = studentDao.findByIdAndName(1,"王钰");
           System.out.println(student);
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
