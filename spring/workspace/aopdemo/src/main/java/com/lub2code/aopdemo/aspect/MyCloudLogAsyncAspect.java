package com.lub2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
    @Before("com.lub2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")  // @Order(3391)
    public void logToCloudAsync(){
        System.out.println("\n===========>> 클라우드 동기화에 관련한 기록을 남깁니다...");
    }
}
