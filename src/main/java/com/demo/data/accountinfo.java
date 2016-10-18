package com.demo.data;

//import javax.persistence.*;

/**
 * Created by qiutian on 16-10-6.
 */
//@Entity
//@Table(name = "t_accountinfo")
public class accountinfo {
    /*
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
*/
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;

    private Integer balance;

    public accountinfo() {}

    public accountinfo(Integer balance) {
        this.balance = balance;
    }
}
