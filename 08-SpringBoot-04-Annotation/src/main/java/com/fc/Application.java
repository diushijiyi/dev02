package com.fc;

import com.fc.config.TestConfig;
import com.fc.entity.Car;
import com.fc.entity.Cat;
import com.fc.entity.Person;
import com.fc.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheType;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext=SpringApplication.run(Application.class, args);
//        String[] names = applicationContext.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//        从容器中获取Bean对象
        TestConfig testConfig = applicationContext.getBean(TestConfig.class);
        System.out.println("hashCode:"+testConfig.hashCode());
        System.out.println("地址："+testConfig);
        User user1 = applicationContext.getBean(User.class);
        User user2 = applicationContext.getBean(User.class);
        System.out.println("容器中的两个对象"+(user1==user2));

        User user3 = testConfig.getUser();
        User user4 = testConfig.getUser();
        System.out.println("new出来的两个对象"+(user3==user4));
        System.out.println("容器中和new出来的两个对象"+(user1==user4));
        System.out.println("---------------");
        Person person = applicationContext.getBean(Person.class);
        Car car = applicationContext.getBean(Car.class);
//        Car newCar = testConfig.getCar();
//        person.setCar(newCar);
        System.out.println("人的车和容器中的车:"+(person.getCar()==car));
        Car carCar = applicationContext.getBean("car2", Car.class);
        System.out.println(carCar);
        System.out.println("---------------");
        Cat cat = applicationContext.getBean("com.fc.entity.Cat",Cat.class);
        System.out.println("从容器中拿到的猫"+cat);

    }

}
