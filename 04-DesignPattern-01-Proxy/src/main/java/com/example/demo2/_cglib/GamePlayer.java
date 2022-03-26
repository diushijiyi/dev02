package com.example.demo2._cglib;

import com.example.demo2._static.GamePlay;

//游戏玩家，被代理对象
public class GamePlayer implements GamePlay {
    private final String username;

    public GamePlayer(String username) {
        this.username = username;
    }

    @Override
    public void login() {
        System.out.println(username+"使用 账号 登录游戏");
    }

    @Override
    public void killBoss() {
        System.out.println(username+"一刀99999");

    }

    @Override
    public void upgrade() {
        System.out.println(username+"恭喜 升了一级");
    }
}
