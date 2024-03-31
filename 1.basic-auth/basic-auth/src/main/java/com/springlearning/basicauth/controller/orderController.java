package com.springlearning.basicauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/")
public class orderController {
    List<String> orders;
    public orderController() {
        orders = new ArrayList<>();
        orders.add("biryani");
        orders.add("gulab-jamun");
    }

    @GetMapping("/orders")
    public List<String> allOrder(){
        // security-context-holder holds security-context object
        // security-context object stores authentication object which store credentials
        SecurityContext securityContext = SecurityContextHolder.getContext();
        // provide authentication of currently logged in user, not all users in application
        Authentication authentication = securityContext.getAuthentication();
        String name  = authentication.getName();
        Object principal = authentication.getPrincipal();
        System.out.println(name + "     " + principal.toString());
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if(authorities != null){
            System.out.println("authorities "+authorities.toString());
        }
        Object credentials = authentication.getCredentials();
        if(credentials != null){
            System.out.println("credentials " + credentials.toString());
        }
        return orders;
    }

    @GetMapping("order/{id}")
    public String getOrder(@PathVariable int id){
        return orders.get(id);
    }
}
