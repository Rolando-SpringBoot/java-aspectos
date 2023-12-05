package com.example.springaop.pildoras.lesson_1.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginWithAspect {

  /*
    Pointcut at package level
    @Pointcut("execution(public * com.example.springaop.pildoras.lesson_1.dao.*.*(..))")
    @Pointcut("execution(* com.example.springaop.pildoras.lesson_1.dao.*.*(..))")
    @Pointcut("execution(* com.example.springaop.pildoras.lesson_1.dao.ClientDAO.*(..))")
    @Pointcut("execution(* com.example.springaop.pildoras.lesson_1.dao.*.getNormalClientRating(..))")
    @Pointcut("execution(* com.example.springaop.pildoras.lesson_1.dao.*.*(..))")
    @Pointcut("execution(void com.example.springaop.pildoras.lesson_1.dao.*.*(..))")
    @Pointcut("execution(* com.example.springaop.pildoras.lesson_1.dao.*.get*(..))")
   */
  @Pointcut("execution(* com.example.springaop.pildoras.lesson_1.dao.*.*(..))")
  private void toClients() {}
  @Pointcut("execution(* com.example.springaop.pildoras.lesson_1.dao.*.get*(..))")
  private void toGetters() {}
  @Pointcut("execution(* com.example.springaop.pildoras.lesson_1.dao.*.set*(..))")
  private void toSetters() {}
  // Combine Pointcuts
  @Pointcut("toClients() && !(toGetters() || toSetters())")
  private void packageExceptGetterSetter() {}

  @Pointcut("toClients() && !toSetters()")
  private void packageExceptSetter() {}

  /*
    Pointcut at method level
    @Before("execution(public void saveClient())")
    @Before("execution(public * saveClient*())")
    @Before("execution(public void saveClient*(..))")
    @Before("execution(public void saveClient*(*, *))")
    @Before("execution(public void saveClient*(com.example.springaop.pildoras.lession_1.domain.Client, ..))")
    @Before("execution(public void saveClient*(..))")
  */
//  @Before("toClients()")
//  @Before("packageExceptGetterSetter()")
  @Before("packageExceptSetter()")
  public void beforeToSaveClient() {
    System.out.println("El usuario está registrado");
    System.out.println("El perfil para insertar clientes es correcto");
  }

//  @Before("toClients()")
  public void requirementsClient() {
    System.out.println("El cliente cumple los requisitos para ser insertado en la BBDD");
  }

//  @Before("toClients()")
  public void requirementsTableClient() {
    System.out.println("Hay menos de 3000 registros en la tabla. Puedes insertar el nuevo cliente");
  }

}
