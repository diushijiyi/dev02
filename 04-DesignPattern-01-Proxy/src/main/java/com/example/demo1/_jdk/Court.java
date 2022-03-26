package com.example.demo1._jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Court {
    @Test
    public void test(){
        Lawsuit parties = new Parties();
        InvocationHandler lawOffice = new LawOffice(parties);
        Lawsuit proxy = (Lawsuit) Proxy.newProxyInstance(parties.getClass().getClassLoader(),
                parties.getClass().getInterfaces(), lawOffice);
        proxy.submit();
        proxy.defend();

    }
}
