package com.applexzs.springboot.aop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class GreetingAspect {

    private Logger log = LoggerFactory.getLogger(GreetingAspect.class);

    @Before("execution(String com.applexzs.springboot.aop.services.IGreetingService.sayHello(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("Antes: " + method + " con los argumentos " + args);
    }
}
