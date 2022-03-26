package com.example.test;

import com.example.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }
    @Test
    public void testFactory(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student2 = applicationContext.getBean("student2", Student.class);
        System.out.println(student2);
    }
    @Test
    public void testStaticFactory(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student3 = applicationContext.getBean("student3", Student.class);
        System.out.println(student3);
    }
}
