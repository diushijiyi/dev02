package com.example.demo2._jdk;

//游戏玩家，被代理对象
public class GamePlayer implements GamePlay {
    @Override
    public void login() {
        System.out.println("使用 账号 登录游戏");
    }

    @Override
    public void killBoss() {
        System.out.println("一刀99999");

    }

    @Override
    public void upgrade() {
        System.out.println("恭喜 升了一级");
    }
}
