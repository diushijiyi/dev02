package com.example.test;

import com.example.dao.impl.JDBCTemplateDaoImpl;
import com.example.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void testUpdate(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl applicationContextBean = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        int affected=applicationContextBean.update(new User(2,null,"326"));
        System.out.println(affected);

    }
    @Test
    public void testDelete(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl applicationContextBean = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        int affected=applicationContextBean.delete(66);
        System.out.println(affected);

    }
    @Test
    public void testInsert(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl applicationContextBean = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        int affected=applicationContextBean.insert(new User(null,"老坛酸菜","11111111"));
        System.out.println(affected);

    }
    @Test
    public void testFindCount(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl templateDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        int count = templateDao.findCount();
        System.out.println(count);
    }
    @Test
    public void testFindAll(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl userDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        List<User> users = userDao.findAll();
        System.out.println(users);

    }
    @Test
    public void testFindById(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTemplateDaoImpl userDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);
        User users = userDao.findById(1);
        System.out.println(users);

    }
}
