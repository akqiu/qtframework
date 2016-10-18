package com.demo.service;

/**
 * Created by qiutian on 16-9-27.
 */
public class accountinfoDto {

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private int accountId;

    private int balance;
}
