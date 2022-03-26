package com.example.test;

import com.example.entity.Student;
import com.example.entity.Teacher;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean(Student.class);
        System.out.println(student);
        Teacher teacher = applicationContext.getBean(Teacher.class);
        System.out.println(teacher);
    }
}
