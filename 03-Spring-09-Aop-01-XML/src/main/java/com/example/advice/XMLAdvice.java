package com.example.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class XMLAdvice {
    public void before(){
        System.out.println("前置通知，会在方法执行前执行");
    }
    public void afterReturning(){
        System.out.println("后置通知，目标方法运行之后调用 ");
    }
    public void afterThrowing(){
        System.out.println("异常通知，出现异常调用");
    }

    public void after(){
        System.out.println("最终通知，无论是否发生异常都会执行");
    }
    public Object around(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("环绕通知之前");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知之后");
        return proceed;
    }
}
