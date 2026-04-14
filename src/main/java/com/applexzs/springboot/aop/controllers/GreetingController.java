package com.applexzs.springboot.aop.controllers;


import com.applexzs.springboot.aop.services.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class GreetingController {

    @Autowired
    private IGreetingService greeting;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {
        return ResponseEntity.ok(Collections.singletonMap("greetings", greeting.sayHello("Pepe", "Hola que tal")));
    }

    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError() {
        return ResponseEntity.ok(Collections.singletonMap("greetings", greeting.sayHelloError("Pepe", "Hola que tal")));
    }
}
