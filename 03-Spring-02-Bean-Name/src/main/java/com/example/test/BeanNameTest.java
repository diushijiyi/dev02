package com.example.test;

import com.example.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanNameTest {
    @Test
    public void testId(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object bean = context.getBean("student");
        System.out.println(bean);
    }
}
