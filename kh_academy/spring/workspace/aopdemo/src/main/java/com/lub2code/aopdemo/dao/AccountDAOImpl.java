package com.lub2code.aopdemo.dao;

import com.lub2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + " : getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : setServiceCode");
        this.serviceCode = serviceCode;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " : DB 작업중입니다. -> 계정 생성 메소드(addAccount())");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": DB 작업입니다, -> 작업용 메서드(doWork())");

        return false;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        // 매개변수로 true값이 전달되면 강제적으로 예외를 발생시킴
        if(tripWire){
            throw new RuntimeException("강제로 발생시킨 예외");
        }

        List<Account> myAccounts = new ArrayList<>();

        // 샘플 어카운트들을 생성
        Account temp1 = new Account("Alice", "theStranger");
        Account temp2 = new Account("Bruce", "theBanner");
        Account temp3 = new Account("Charles", "noXavier");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        // 생성한 샘플들을 리스트에 추가
        return myAccounts;
    }
}
