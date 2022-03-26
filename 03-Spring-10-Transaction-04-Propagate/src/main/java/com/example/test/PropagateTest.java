package com.example.test;

import com.example.config.TxConfig;
import com.example.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropagateTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
        accountService.addAccount("海绵宝宝","菠萝屋");
    }
}
