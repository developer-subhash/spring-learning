package com.subhash.spring_test.controller;

import com.subhash.spring_test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/getAccounts")
    public String getAccounts(){
//        return "here are all accounts";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authenticated user is " + authentication.getPrincipal().toString());
        return accountService.getAllAccounts();
    }
}
