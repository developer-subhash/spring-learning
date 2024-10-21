package com.subhash.spring_test.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public String getAllAccounts(){
        return "here are all accounts list";
    }
}
