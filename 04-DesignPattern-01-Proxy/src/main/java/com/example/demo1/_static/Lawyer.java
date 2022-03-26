package com.example.demo1._static;
//律师，代理对象
public class Lawyer implements Lawsuit{
    private final Lawsuit parties;

    public Lawyer(Lawsuit parties) {
        this.parties = parties;
    }

    @Override
    public void submit() {
        this.gatherEvidence();
        parties.submit();
    }

    @Override
    public void defend() {
        parties.defend();
        this.exchangeOpinions();
    }
//    收集证据
    private void gatherEvidence(){
        System.out.println("收集证据");
    }
//    交换意见
    private void exchangeOpinions(){
        System.out.println("交换意见");
    }
}
