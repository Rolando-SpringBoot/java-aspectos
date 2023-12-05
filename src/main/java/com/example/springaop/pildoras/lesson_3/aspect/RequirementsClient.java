package com.example.springaop.pildoras.lesson_3.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class RequirementsClient {

  @Before("com.example.springaop.pildoras.lesson_3.aspect.LoginWithAspect.toClients()")
  public void requirementsClient() {
    System.out.println("El cliente cumple los requisitos para ser insertado en la BBDD");
  }

}
