package com.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

//@RestController
//@EnableAutoConfiguration
@SpringBootApplication
public class MyApplication {
//    @RequestMapping("/")
//    String home(){
//        return "Hello World!";
//    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        SpringApplication.run(MyApplication.class,args);
    }
}
