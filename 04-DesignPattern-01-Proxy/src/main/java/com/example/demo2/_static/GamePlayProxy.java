package com.example.demo2._static;
//代练，代理
public class GamePlayProxy implements GamePlay{
    private final GamePlay player;

    public GamePlayProxy(GamePlay player) {
        this.player = player;
    }

    @Override
    public void login() {
        this.verify();
        player.login();
    }

    @Override
    public void killBoss() {
        player.killBoss();
        this.addMoney();
    }

    @Override
    public void upgrade() {
        player.upgrade();
    }
    private void verify(){
        System.out.println("请输入您的手机验证码");
    }
    private void addMoney(){
        System.out.println("掉了一堆金币，和一把屠龙宝刀");
    }
}
