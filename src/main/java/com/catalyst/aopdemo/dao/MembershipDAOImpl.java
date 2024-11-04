package com.catalyst.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

//    @Override
//    public void addAccount() {
//
////        System.out.println(getClass() + " : DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
//
//    }

//    @Override
//    public void addSilly() {
//
//        System.out.println(getClass() + " : DOING MY DB WORK: ADDING A  SILLY MEMBERSHIP ACCOUNT");
//    }

    @Override
    public boolean addSilly() {

        System.out.println(getClass() + " : DOING MY DB WORK: ADDING A  SILLY MEMBERSHIP ACCOUNT");
        return  true;
    }

    @Override
    public void goToSleep() {

        System.out.println(getClass() + ":  I am going to sleep now..");

    }
}
