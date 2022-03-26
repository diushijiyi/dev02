package com.example.factory;

import com.example.entity.Student;

public class StudentFactory {
    public Student getStudent(){
        return new Student();
    }
}
