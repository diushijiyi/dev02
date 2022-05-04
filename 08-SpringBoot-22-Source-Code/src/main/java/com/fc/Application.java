package com.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;

//这三个注解组合到一起就拥有了启动类的功能
@SpringBootConfiguration
@EnableAutoConfiguration
//手动指定包扫描路径
@ComponentScan("com")
public class Application {

    public static void main(String[] args) {

        //        启动SpringBoot时可以获取到Spring容器
        ApplicationContext context = SpringApplication.run(Application.class, args);

//        获取所有容器中的组件名称
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
