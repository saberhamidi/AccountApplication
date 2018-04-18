package com.infosys.application;

import com.infosys.domain.Account;
import com.infosys.service.AccountService;
import com.infosys.util.JsonUtil;

public class App {

    public static void main(String[] args){

        AccountService accountService = new AccountService();
        Account myAccount = new Account("Saber", "Hamidi", 35352345);
        Account baharAccount = new Account("Bahar", "Hamidi", 7754345);
        JsonUtil jsonUtil = new JsonUtil();

        accountService.addAccount(myAccount);
        accountService.addAccount(baharAccount);
        String accountsInJSON = jsonUtil.JavaToJson(accountService.getAccounts());
        System.out.println("Accounts: "+accountsInJSON);
    }
}
