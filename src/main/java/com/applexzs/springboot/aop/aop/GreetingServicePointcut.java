package com.applexzs.springboot.aop.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcut {

    @Pointcut("execution(String com.applexzs.springboot.aop.services.IGreetingService.*(..))")
    public void greetingLoggerPointCut() {}

    @Pointcut("execution(String com.applexzs.springboot.aop.services.IGreetingService.*(..))")
    public void greetingFooAspectPointcut() {}

}
