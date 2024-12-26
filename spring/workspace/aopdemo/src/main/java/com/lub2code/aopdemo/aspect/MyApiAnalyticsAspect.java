package com.lub2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("com.lub2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")  // @Order(3391)
    public void performApiAnalytics(){
        System.out.println("\n=========>> API 분석 실행중...");
    }
}
