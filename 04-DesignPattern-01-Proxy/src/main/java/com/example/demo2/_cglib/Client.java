package com.example.demo2._cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class Client {
    @Test
    public void test(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(GamePlayer.class);
        enhancer.setCallback(new GameOffice());
        GamePlayer proxy =(GamePlayer) enhancer.create(new Class[] {String.class},new Object[]{"豪杰"});
        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }
}
