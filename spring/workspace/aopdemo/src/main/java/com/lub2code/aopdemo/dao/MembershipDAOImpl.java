package com.lub2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + " : DB 작업중입니다. -> 멤버쉽 추가 메소드(addAccount())");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " : DB 작업중입니다. -> 수면용 추가 메소드(goToSleep())");
    }
}
