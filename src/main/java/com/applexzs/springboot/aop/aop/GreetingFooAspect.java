package com.applexzs.springboot.aop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Aspect
@Component
public class GreetingFooAspect {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Before("execution(String com.applexzs.springboot.aop.services.IGreetingService.*(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("Antes primero: " + method + " invocados con los parametros " + args);
    }

    @After("execution(String com.applexzs.springboot.aop.services.IGreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("Despues primero: " + method + " invocado con los parametros " + args);
    }

}
