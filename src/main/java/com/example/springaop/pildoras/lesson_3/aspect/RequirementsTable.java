package com.example.springaop.pildoras.lesson_3.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class RequirementsTable {

  @Before("com.example.springaop.pildoras.lesson_3.aspect.LoginWithAspect.toClients()")
  public void requirementsTableClient() {
    System.out.println("Hay menos de 3000 registros en la tabla. Puedes insertar el nuevo cliente");
  }

}
