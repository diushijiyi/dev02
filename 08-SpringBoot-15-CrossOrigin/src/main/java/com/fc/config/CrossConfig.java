package com.fc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@Configuration
public class CrossConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        控制器的访问路径
        registry.addMapping("/**")
//                允许携带cookie
                .allowCredentials(true)
//                允许源
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("DELETE","GET","PUT","POST","OPTIONS")
                .maxAge(3600);
    }
}
