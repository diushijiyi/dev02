package com.example.test;

import com.example.entity.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    @Test
    public void testSelect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/rx05?useSSL=false&useUnicode=true&characterEncoding=UTF8";
            String username="root";
            String password="123456";
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql="select * from student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Student> students = new ArrayList<>();
            while (resultSet.next()){
                Student student=new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                student.setGender(resultSet.getString(4));
                student.setInfo(resultSet.getString(5));
                students.add(student);
                
            }
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAdd(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/rx05?useSSL=false&useUnicode=true&characterEncoding=UTF8";
            String username="root";
            String password="123456";
            String sql="insert into student(name,age,gender,info) values(?,?,?,?)";
            Connection connection=DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"易烊千玺");
            preparedStatement.setInt(2,22);
            preparedStatement.setString(3,"男");
            preparedStatement.setString(4,"四个字");
            int affectedRows=preparedStatement.executeUpdate();
            System.out.println("受影响的行数："+affectedRows);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
