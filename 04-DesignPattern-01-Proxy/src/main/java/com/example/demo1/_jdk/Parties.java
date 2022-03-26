package com.example.demo1._jdk;

//原告，被代理对象
public class Parties implements Lawsuit {

    @Override
    public void submit() {
        System.out.println("厂倒闭了，老板跑路了");
    }

    @Override
    public void defend() {
        System.out.println("还我血汗钱");
    }
}
