package com.lub2code.aopdemo.aspect;

import com.lub2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {

    @AfterThrowing(pointcut = "execution(* com.lub2code.aopdemo.dao.AccountDAO.findAccounts(..))",
                    throwing = "theExc")
    public void afterThrowingFindAccounts(JoinPoint theJoinPoint, Throwable theExc){
        // 우리가 advice를 붙일 메서드를 출력

        // 예외를 기록(출력)

    }

    // @AfterReturning을 findAccounts 메서드에 붙일 advice를 생성
    @AfterReturning(pointcut = "execution(* com.lub2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAdvice(JoinPoint theJoinPoint, List<Account> result) {
        // 우리가 advice를 붙이는 메서드를 출력
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n============>> @AfterReturning이 다음 메서드에 붙어 있음 : " + method);

        // 메서드가 호출된 이후에 리턴된 데이터를 가져와서 출력
        System.out.println("\n=======>> 리턴된 데이터 : " + result);

        // 여기서 리턴된 데이터를 후처리

        // 리턴된 Account 객체의 이름을 모두 대문자로 변경
        convertAccountNamesToUpperCase(result);
        System.out.println("\n========> 후처리된 데이터 : " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // Account 객체가 담긴 리스트의 내용을 반복
        for (Account tempAccount : result) {
            // Account 객체의 이름을 얻어와서 대문자로 변환
            String theUpperName = tempAccount.getName().toUpperCase();
            // Account 객체의 이름을 업데이트
            tempAccount.setName(theUpperName);
        }
    }


    @Pointcut("com.lub2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()") // @Order(0)
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====> @Before advice가 addAccount()에 붙어서 실행되는 중");

        // 메소드 시그니처를 표시
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("메소드 : " + methodSignature);
        // 메소드가 가지고 있는 매개변수들을 출력

        // 매개변수를 얻어옴
        Object[] args = theJoinPoint.getArgs();
        // 매개변수를 반복적으로 처리
        for (Object tempArg : args) {
            System.out.println(tempArg);
            if (tempArg instanceof Account theAccount) {
                System.out.println("Account 이름 : " + theAccount.getName());
                System.out.println("Account 권한 : " + theAccount.getLevel());
            }
        }
    }
}
