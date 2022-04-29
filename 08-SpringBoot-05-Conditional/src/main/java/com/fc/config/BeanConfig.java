package com.fc.config;

import com.fc.entity.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
//    @Bean("Bike")
//    @ConditionalOnMissingBean(Bike.class)
//    @ConditionalOnBean(Person.class)
//    public Bike getBike(){
//        return new Bike();
//    }
    @Bean("car")
    @ConditionalOnMissingBean({Bike.class,Car.class})
    @ConditionalOnBean(Person.class)
    public Car getCar(){
        Car car = new Car();
        car.setBrand("BYD");
        return car;
    }
    @Bean("car2")
    public Car getCar2(){
        Car car = new Car();
        car.setBrand("特斯拉");
        return car;
    }
//    @Bean("wife")
    public Wife getWife(){
        return new Wife();
    }
    @Bean("son")
    @ConditionalOnBean(Wife.class)
    public Son getSon(){
        return new Son();
    }

    @Bean("girlFriend")
    @ConditionalOnMissingBean(Wife.class)
    public GirlFriend getGirlFriend(){
        return new GirlFriend();
    }
}
