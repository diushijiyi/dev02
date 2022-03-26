package com.example.test;

import com.example.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student.getId());
        System.out.println(student.getAge());
        System.out.println(student.getName());
    }
}
