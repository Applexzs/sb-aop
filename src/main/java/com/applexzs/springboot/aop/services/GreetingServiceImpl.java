package com.applexzs.springboot.aop.services;


import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements IGreetingService{

    @Override
    public String sayHello(String person, String phrase) {
        String greeting = phrase + " "  + person;
        System.out.println(greeting);
        return greeting;
    }
}
