package com.example.demo.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.logistics.*.*(..))")
    public void logBeforeMethod() {
        System.out.println("Method execution started...");
    }
}