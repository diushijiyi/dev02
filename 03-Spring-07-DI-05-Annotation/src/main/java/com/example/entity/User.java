package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@AllArgsConstructor
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class User {
    @Value("101")
    private Integer id;
    @Value("易烊千玺")
    private String username;
    @Value("123")
    private String password;
    @PostConstruct
    public void eat(){
        System.out.println("今天中午吃饭");
    }
    @PreDestroy
    public void sleep(){
        System.out.println("吃了就睡");
    }

    public User() {
        System.out.println("无参构造");
    }
}
