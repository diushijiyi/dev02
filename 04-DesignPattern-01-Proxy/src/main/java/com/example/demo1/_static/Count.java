package com.example.demo1._static;

import org.junit.Test;

public class Count {
    @Test
    public void test(){
//        原告
        Lawsuit parties = new Parties();
//        律师
        Lawyer lawyer = new Lawyer(parties);
        lawyer.submit();
        lawyer.defend();
    }
}
