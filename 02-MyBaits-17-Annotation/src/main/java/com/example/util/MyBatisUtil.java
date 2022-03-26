package com.example.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory FACTORY;
    private static final ThreadLocal<SqlSession> SESSIONS=new ThreadLocal<>();
    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            FACTORY=new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    private static SqlSession openSession(){
        SqlSession session = SESSIONS.get();
        if (session==null){
            session=FACTORY.openSession();
            SESSIONS.set(session);
        }
        return session;
    }
    private static void close(){
        SqlSession session = SESSIONS.get();
        session.close();
        SESSIONS.remove();
    }
    public static <T>T getMapper(Class<T> clazz){
        SqlSession session = openSession();
        return session.getMapper(clazz);
    }
    public static void commit(){
        SqlSession session = openSession();
        session.commit();
        close();
    }
    public static void rollback(){
        SqlSession session = openSession();
        session.rollback();
        close();
    }
}
