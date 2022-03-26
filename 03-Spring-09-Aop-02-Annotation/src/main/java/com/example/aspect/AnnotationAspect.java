package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAspect {
    @Pointcut("execution(* com.example.service.impl.*ServiceImpl.*(..))")
    public static void pointCut(){}
    @Before("AnnotationAspect.pointCut()")
    public void before(){
        System.out.println("前置通知，方法执行前调用");
    }
    @AfterReturning("AnnotationAspect.pointCut()")
    public void afterReturning(){
        System.out.println("后置通知，出现异常时不执行");
    }
    @AfterThrowing("AnnotationAspect.pointCut()")
    public void afterThrowing(){
        System.out.println("异常通知，出现异常时执行");
    }
    @After("AnnotationAspect.pointCut()")
    public void after(){
        System.out.println("最终通知，出现异常时也会调用");
    }
    @Around("AnnotationAspect.pointCut()")
    public Object around(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("环绕之前");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕之后");
        return proceed;
    }
}
