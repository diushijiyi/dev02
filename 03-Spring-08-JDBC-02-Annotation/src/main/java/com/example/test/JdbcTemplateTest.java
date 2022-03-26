package com.example.test;

import com.example.config.JdbcConfig;
import com.example.dao.impl.JDBCTemplateDaoImpl;
import com.example.entity.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateTest {
  @Test
    public void test(){
      AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);
      JDBCTemplateDaoImpl templateDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
    User user = templateDao.findById(1);
    System.out.println(user);
  }
}
