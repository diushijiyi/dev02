package com.example.demo2._static;

import org.junit.Test;

public class Client {
    @Test
    public void test(){
//        真实对象
        GamePlay player = new GamePlayer();

        GamePlay proxy = new GamePlayProxy(player);
        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }

}
