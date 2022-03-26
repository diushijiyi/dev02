package com.example.entity;

public class Teacher {
    private String name;
    private Integer age;
    private Student student;

    public Teacher() {

    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", student=" + student +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher(String name, Integer age, Student student) {
        this.name = name;
        this.age = age;
        this.student = student;
    }
}
