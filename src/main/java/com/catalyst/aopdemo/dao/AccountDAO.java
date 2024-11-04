package com.catalyst.aopdemo.dao;

import com.catalyst.aopdemo.Account;

import java.util.List;

public interface AccountDAO {


//    void addAccount();

//    void addAccount(Account theAccount);
    void addAccount(Account theAccount, boolean vipFlag);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
