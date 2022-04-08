package com.example.Test;

import org.junit.Test;

public class ExceptionTest {
    @Test
    public void test(){
        int[] array=new int[1024*1024*1024*1024];
        array[0]=1;
    }
    public void eat(){
        System.out.println("干饭");
    }
}
