package com.springlearning.springjms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    // containerFactory - message listener container , container which listen message from broker server
    // destination - queue present on boker server
    @JmsListener(destination = "personInfo", containerFactory = "myFactory")
    public void receiveMessage(Message message){
        System.out.println("received message is " + message.toString());
    }
}
