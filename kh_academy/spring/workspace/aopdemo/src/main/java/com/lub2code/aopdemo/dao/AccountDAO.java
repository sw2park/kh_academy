package com.lub2code.aopdemo.dao;

import com.lub2code.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    public String getName();
    public void setName(String name);
    public String getServiceCode();
    public void setServiceCode(String serviceCode);

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}

