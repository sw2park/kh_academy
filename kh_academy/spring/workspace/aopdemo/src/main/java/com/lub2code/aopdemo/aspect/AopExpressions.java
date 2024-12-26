package com.lub2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {
    // 여기는 @Before advice 메서드가 추가될 자리
    @Before("execution(* com.lub2code.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){} // private void forDaoPackage();

    // getter와 setter를 제외하는 포인트컷 표현식
    @Pointcut("execution(* com.lub2code.appdemo.dao.*.get*(..))")
    public void getter(){}
    @Pointcut("execution(* com.lub2code.appdemo.dao.*.set*(..))")
    public void setter(){}

    // getter와 setter를 조합해서 선택하는 표현식
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
