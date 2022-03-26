package com.example.entity;

public class Student {
    private Integer id;
    private String name;
    private Byte age;

    public Student() {
        System.out.println("无参构造被执行");
    }

    public Student(Integer id, String name, Byte age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public void init(){
        System.out.println("初始化方法被执行");
    }
    public void destroy(){
        System.out.println("销毁方法被执行");
    }
}
