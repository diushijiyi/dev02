package com.example.test;

import com.example.entity.ComplexType;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComplexType complexType = applicationContext.getBean(ComplexType.class);
        System.out.println(complexType);
    }
}
