package com.example.springaop.pildoras.lesson_4.aspect;

import com.example.springaop.pildoras.lesson_4.domain.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AppAspect {

  /*
    Pointcut Designators
    execution - for matching method execution join points.
    within - for matching methods of classes within certain types e.g classes within package
    @within - for matching to join points within types (target object class) that have the given annotation
    this - for matching to join points (the execution of methods) where the bean reference (Spring AOP proxy)
      is an instance of the given type.
    target - for matching with the target object of the specific instance type
    @target - for matching with the target object annotated with a specific annotation
    args - for matching with methods where its arguments are of a specific type
    @args - for matching with methods where its arguments are annotated with a specific annotation on its classes
    @annotation - for matching join points where the subject (method) of the joinpoint has the given annotation
    bean - this PCD lets you limit the matching of join points to a particular named Spring bean or to a set
      of named Spring beans (when using wildcards).

     Curiosities:
      - aspect can detect annotations, whereas it had a class retention
      - within is invoked on methods which are executed by instance of classes that is referenced
      - execute is invoked regardless if it refers to instance of class or the parent class
      - args don't allow use of more than one '..' in the expression.
      - when you want to validate annotations with any expressions. It only works at class or method level
        depending on the pointcut designator. For example, @within, @args detect annotation at class level
        and @annotation detects annotation at method level.
   */

  @Pointcut("execution(public com.example.springaop.pildoras.lesson_4.domain.Person "
      + "com.example.springaop.pildoras.lesson_4.service.AppService.findById(Long))")
  private void serviceFindById() {}

  @Pointcut("execution(public * *(.., @com.example.springaop.pildoras.lesson_4.annotation.Loggeable "
      + "com.example.springaop.pildoras.lesson_4.domain.Person, ..))")
  private void methodExecutionWithParameterHasClassAnnotated() {}

  @Pointcut("within(com.example.springaop.pildoras.lesson_4..*)")
  private void lesson4Package() {}

  @Pointcut("within(com.example.springaop.pildoras.lesson_4.service.impl.*)")
  private void anyMethodWithinClassesOnServiceImplPackage() {}

  @Pointcut("@within(com.example.springaop.pildoras.lesson_4.annotation.Loggeable)")
  private void anyMethodWithinClassesWithAnnotationLoggeableOnClass() {}

//  @Pointcut("args(Long, @com.example.springaop.pildoras.lesson_4.annotation.Loggeable com.example.springaop.pildoras.lesson_4.domain.Person)")
  @Pointcut("args(Long, com.example.springaop.pildoras.lesson_4.domain.Person)")
  private void anyMethodWithTheseTypesOfArguments() {}

  @Pointcut("@args(com.example.springaop.pildoras.lesson_4.annotation.Loggeable)")
  private void anyMethodWithThiAnnotationOfArgument() {}

  @Pointcut("@annotation(com.example.springaop.pildoras.lesson_4.annotation.Loggeable)")
  private void anyMethodWithHasThisAnnotationOnItself() {}

//  @Before("serviceFindById()")
//  public void adviceServiceFindById() {
//    System.out.println("executing before advice service findById");
//  }

//  @Before("anyMethodWithinClassesOnServiceImplPackage()")
//  public void adviceAnyMethodWithinClassesOnServiceImplPackage() {
//    System.out.println("executing before advice any method within classes on service impl package");
//  }

//  @Before("anyMethodWithinClassesWithAnnotationLoggeable()")
//  public void adviceAnyMethodWithinClassesWithAnnotationLoggeableOnClass() {
//    System.out.println("executing before advice any method within classes with annotation loggeable on class");
//  }

//  @Before("anyMethodWithTheseTypesOfArguments()")
//  public void adviceAnyMethodWithTheseTypesOfArguments() {
//    System.out.println("executing before advice any method with these types of arguments");
//  }

//  @Before("lesson4Package() && anyMethodWithThisAnnotationsOfArgument()")
//  public void adviceAnyMethodWithThisAnnotationOfArgument(JoinPoint joinPoint) {
//    System.out.println(joinPoint.getSignature());
//    System.out.println("executing before advice any method with this annotation of argument");
//  }

//  @Before("lesson4Package() && methodExecutionWithParameterHasClassAnnotated()")
//  public void adviceMethodExecutionWithParameterHasAnnotated(JoinPoint joinPoint) {
//    System.out.println(joinPoint.getSignature());
//    System.out.println("advice method execution with parameter has class annotated");
//  }

//  @Before("lesson4Package() && anyMethodWithHasThisAnnotationOnItself()")
//  public void adviceAnyMethodWithHasThisAnnotationOnItself(JoinPoint joinPoint) {
//    System.out.println(joinPoint.getSignature());
//    System.out.println("advice any method with has this annotation on itself");
//  }

}
