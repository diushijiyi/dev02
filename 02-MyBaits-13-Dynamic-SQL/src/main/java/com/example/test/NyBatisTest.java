package com.example.test;

import com.example.dao.StudentDao;
import com.example.entity.Student;
import com.example.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class NyBatisTest {
    @Test
    public void testDeleteMore(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        int affected = studentDao.deleteMore(10, 11, 13);
        System.out.println(affected);
        MyBatisUtil.commit();
    }
    @Test
    public void testUpdateWithTrim() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student=new Student();
        student.setId(12);
        student.setInfo("睡觉");
        student.setAge((byte)31);
        int update = studentDao.updateWithTrim(student);
        System.out.println(update);
        MyBatisUtil.commit();
    }
    @Test
    public void testUpdate() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student=new Student();
        student.setId(5);
        student.setName("赵芮");
        student.setInfo("城隍狮王");
        student.setAge((byte)20);
        int update = studentDao.update(student);
        System.out.println(update);
        MyBatisUtil.commit();
    }
    @Test
    public void testFindByStudentWithTrim(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student=new Student();
        student.setGender("女");
        student.setAge((byte)20);
        List<Student> students = studentDao.findByStudentWithTrim(student);
        for (Student student1 : students) {
            System.out.println(student1);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void testFindByStudent(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student=new Student();
        student.setGender("女");
        student.setAge((byte)20);
        List<Student> students = studentDao.findByStudent(student);
        for (Student student1 : students) {
            System.out.println(student1);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void testFindKeyword(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> students = studentDao.findByKeyword("%王%", 20);
        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void testFindAll(){
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
