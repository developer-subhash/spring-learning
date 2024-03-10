package com.springlearning.basicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
        return orders;
    }

    @GetMapping("order/{id}")
    public String getOrder(@PathVariable int id){
        return orders.get(id);
    }
}
