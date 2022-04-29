package com.fc.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;


public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String[] profiles={"jdbc.properties","person.yml"};
        for (String profile : profiles) {
            Resource resource = new ClassPathResource(profile);
            environment.getPropertySources().addLast(load(resource));

        }
    }
    private PropertySource<?> load(Resource resource){
        if (!resource.exists()){
            throw new IllegalArgumentException("配置文件不存在"+resource);
        }
        if (resource.getFilename().contains(".yml")){
            return loadYml(resource);
        }else {
            return loadProperties(resource);
        }
    }

    private PropertySource<?> loadYml(Resource resource) {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(resource);
        Properties properties = factoryBean.getObject();
        return new PropertiesPropertySource(resource.getFilename(), properties);
    }

    private PropertySource<?> loadProperties(Resource resource) {
        Properties properties = new Properties();
        try {
            properties.load(resource.getInputStream());
            return new PropertiesPropertySource(resource.getFilename(), properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
