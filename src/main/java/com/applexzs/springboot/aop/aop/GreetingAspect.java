package com.applexzs.springboot.aop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

    private Logger log = LoggerFactory.getLogger(GreetingAspect.class);

    @Pointcut("execution(String com.applexzs.springboot.aop.services.IGreetingService.*(..))")
    private void greetingLoggerPointCut() {}

    @Before("greetingLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("Antes: " + method + " con los argumentos " + args);
    }

    @After("greetingLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("Despues: " + method + " con los argumentos " + args);
    }

    @AfterReturning("greetingLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("Despues de retornar: " + method + " con los argumentos " + args);
    }

    @AfterThrowing("greetingLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("Despues lanzar la excepcion: " + method + " con los argumentos " + args);
    }

    @Around("greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            log.info("El metodo " + method + "() con los parametros  " + args);
            result = joinPoint.proceed();
            log.info("El metodo " + method + "() retorna el resultado: " + result);
            return result;
        } catch (Throwable e) {
            e.printStackTrace(System.out);
            log.info("Error en lla llamada del metodo " + method + "()");
        }
        return result;
    }
}
