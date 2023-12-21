package com.example.springaop.pildorasindu.lesson_1.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  /*
    @Before("execution(public String getName())")
    @Before("execution(public String com.example.springaop.pildorasindu.lesson_1.model.Circle.getName())")
    @Before("execution(protected * com.example.springaop.pildorasindu.lesson_1..get*())")
    @Before("execution(* com.example.springaop.pildorasindu.lesson_1..get*(..))")
    @Before("execution(* com.example.springaop.pildorasindu.lesson_1..get*(*))")
    @Before("execution(* com.example.springaop.pildorasindu.lesson_1..get*(..))")
   */

  @Pointcut("execution(* com.example.springaop.pildorasindu.lesson_1..get*(..))")
  public void allGetters() {}

  @Before("allGetters()")
  public void LoggingAdvice() {
    System.out.println("Advice run. Get Method called");
  }

  @Before("allGetters()")
  public void secondAdvice() {
    System.out.println("Second Advice executed");
  }

}
