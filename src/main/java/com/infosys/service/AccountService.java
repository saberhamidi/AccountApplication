package com.infosys.service;

import com.infosys.domain.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private Map<String, Account> accounts;


    public AccountService() {
        this.accounts = new HashMap<String, Account>();
    }

    public void addAccount(Account ac){
        accounts.put(ac.getFirstName(), ac);
    }

    public void removeAccount(String name){
        boolean countExists = accounts.containsKey(name);
        if(countExists){
            accounts.remove(name);
        }
    }

    public Account getAccountByName(String name){
        boolean countExists = accounts.containsKey(name);
        if(countExists){
           return accounts.get(name);
        }
        else {
            return null;
        }
    }

    public int getNumberOfAccountsWithFirstName(String firstName){
        return (int) accounts.values().stream().filter(account -> account.getFirstName().equals(firstName)).count();
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}
