package com.fc.config;

import com.fc.entity.Car;
import com.fc.entity.Person;
import com.fc.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

//此注解表示当前类是一个配置类
@Configuration(proxyBeanMethods = false)
public class TestConfig {
    @Bean({"car","car1","car2"})
    public Car getCar(){
        return new Car("保时捷","粉色");
    }
    @Bean
    public Person getPerson(Car car){
        return new Person("易烊千玺",getCar());
    }
    @Bean
//    @Scope("prototype")
    public User getUser(){
        return new User();
    }
    public TestConfig(){
        System.out.println("构造方法");
    }
    public String test(){
        System.out.println("易烊千玺");
        return "一口一个易烊千玺";
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化");
    }
}
