package com.example.springaop.pildoras.lesson_2.aspect;

import static java.lang.StringTemplate.STR;

import com.example.springaop.pildoras.lesson_2.domain.Client;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 @Order annotation allows you to specify the order of aspect's execution.
 */
@Aspect
@Component
@Order(3)
public class LoginWithAspect {

  @Pointcut("execution(* com.example.springaop.pildoras.lesson_2.dao.*.*(..))")
  public void toClients() {}

  /*
    Before to call method.
    If you want, you can access to arguments method through JoinPoint
   */
  @Before("toClients()")
  public void beforeToSaveClient(JoinPoint joinPoint) {
    // argument method
    System.out.println("El usuario está registrado");
    System.out.println("El perfil para insertar clientes es correcto");
    Object[] arguments = joinPoint.getArgs();

    for(Object arg : arguments) {
      if(arg instanceof Client client) {
        System.out.println(STR."Nombre del cliente: \{client.getName()}");
        System.out.println(STR."Tipo del cliente: \{client.getType()}");
      }
    }

  }

}
