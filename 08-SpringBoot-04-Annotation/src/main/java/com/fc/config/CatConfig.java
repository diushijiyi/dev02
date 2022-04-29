package com.fc.config;

import com.fc.entity.Cat;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(Cat.class)
@Configuration
public class CatConfig {
//    public Cat cat(){
//        return
//    }
//    public CatConfig(){
//
//    }
}
