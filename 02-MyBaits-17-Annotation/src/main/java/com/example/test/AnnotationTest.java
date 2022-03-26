package com.example.test;

import com.example.dao.StudentDao;
import com.example.entity.Student;
import com.example.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class AnnotationTest {
    @Test
    public void testUpdate(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student=new Student();
        student.setId(14);
        student.setInfo("牛牛牛牛牛");
        int affected = studentDao.update(student);
        System.out.println(affected);
        MyBatisUtil.commit();
    }
    @Test
    public void testDelete(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        int affected = studentDao.delete(15);
        System.out.println(affected);
        MyBatisUtil.commit();
    }
    @Test
    public void testInsert(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("汉堡");
        student.setAge((byte)30);
        student.setGender("男");
        student.setInfo("秘制小汉堡");
        int affect = studentDao.insert(student);
        System.out.println(affect);
        MyBatisUtil.commit();
    }
    @Test
    public void testFindById(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student students = studentDao.findById(1);
        System.out.println(students);
        MyBatisUtil.commit();
    }
    @Test
    public void testFindAll(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtil.commit();
    }
}
