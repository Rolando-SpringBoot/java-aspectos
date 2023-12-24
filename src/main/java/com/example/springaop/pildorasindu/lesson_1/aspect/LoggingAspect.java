package com.example.springaop.pildorasindu.lesson_1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  /*
    Within: this expression just apply to classes.
    It means the aspect just apply to method which are into these classes.

    args: this expression is used in a pointcut expression to match method execution
    join points based on arguments passed to the method.
  */
  @Pointcut("execution(* com.example.springaop.pildorasindu.lesson_1..get*(..))")
  public void allGetters() {}


  @Pointcut("within(com.example.springaop.pildorasindu.lesson_1.model.Circle)")
  public void allCircleMethods() {}

  /*
    @Before("allCircleMethods() && allGetters()")
   */
  @Before("allCircleMethods()")
  public void loggingAdvice(JoinPoint joinPoint) {
    System.out.println("Before method circle");
  }

  /*
    @Before("args(String)")
    @Before("args(name)")
   */
  @AfterReturning(value = "allCircleMethods() && args(name)", returning = "result")
  public void stringArgumentMethods(String name, Object result) {
    System.out.println("A method that takes String argument has been called. The value is: " + name);
    System.out.println("The output value is: " + result);
  }

  @AfterThrowing(value = "allCircleMethods() && args(name)", throwing = "ex")
  public void exceptionAdvice(String name, RuntimeException ex) {
    System.out.println("An exception has been thrown. The value is: " + name);
    System.out.println(ex.getMessage());
  }

  @Around("allGetters()")
  public Object myAroundAdvice(ProceedingJoinPoint joinPoint) {
    Object result;
    try {
      System.out.println("Before advice");
      result = joinPoint.proceed();
      System.out.println("After Returning");
    } catch (Throwable e) {
      System.out.println("After throwing");
      throw new RuntimeException(e);
    } finally {
      System.out.println("After finally");
    }

    return result;
  }

}
