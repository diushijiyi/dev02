package com.example.factory;

import com.example.entity.Student;

public class StudentStaticFactory {
    public static Student getStudent(){
        return new Student();
    }
}
