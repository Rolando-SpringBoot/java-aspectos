package com.example.springaop.pildoras.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginWithAspect {

  /*
    Pointcut at package level
    @Pointcut("execution(public * com.example.springaop.pildoras.dao.*.*(..))")
    @Pointcut("execution(* com.example.springaop.pildoras.dao.*.*(..))")
    @Pointcut("execution(* com.example.springaop.pildoras.dao.ClientDAO.*(..))")
    @Pointcut("execution(* com.example.springaop.pildoras.dao.*.getNormalClientRating(..))")
    @Pointcut("execution(* com.example.springaop.pildoras.dao.*.*(..))")
    @Pointcut("execution(void com.example.springaop.pildoras.dao.*.*(..))")
    @Pointcut("execution(* com.example.springaop.pildoras.dao.*.get*(..))")
   */
  @Pointcut("execution(* com.example.springaop.pildoras.dao.*.*(..))")
  private void toClients() {}
  @Pointcut("execution(* com.example.springaop.pildoras.dao.*.get*(..))")
  private void toGetters() {}
  @Pointcut("execution(* com.example.springaop.pildoras.dao.*.set*(..))")
  private void toSetters() {}
  // Combine Pointcuts
  @Pointcut("toClients() && !(toGetters() || toSetters())")
  private void packageExceptGetterSetter() {}

  @Pointcut("toClients() && !toSetters()")
  private void packageExceptSetter() {}

  /*
    Pointcut at method level
    @Before("execution(public void saveClient())")
    @Before("execution(public void com.example.springaop.pildoras.dao.ClientVipDAO.saveClient())")
    @Before("execution(public * saveClient*())")
    @Before("execution(public void saveClient*(..))")
    @Before("execution(public void saveClient*(*, *))")
    @Before("execution(public void saveClient*(com.example.springaop.pildoras.domain.Client, ..))")
    @Before("execution(public com.example.springaop.pildoras.domain.Client saveClient*(..))")
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
