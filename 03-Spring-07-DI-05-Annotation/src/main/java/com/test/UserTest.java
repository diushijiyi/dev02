package com.test;

import com.example.controller.UserController;
import com.example.entity.User;
import com.example.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testIoc(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example");
        UserController userController = applicationContext.getBean(UserController.class);
        System.out.println(userController);
    }
    @Test
    public void testDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = applicationContext.getBean(UserController.class);
        List<User> list = userController.findAll();
        System.out.println(list);
    }
    @Test
    public void testValue(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = applicationContext.getBean(User.class);
//        System.out.println(user);
        applicationContext.close();
    }
}
