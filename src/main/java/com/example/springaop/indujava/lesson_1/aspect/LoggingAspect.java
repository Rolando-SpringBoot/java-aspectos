package com.example.springaop.indujava.lesson_1.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  @Before("execution(public String getName())")
  public void LoggingAdvice() {
    System.out.println("Advice run. Get Method called");
  }

}
