package com.example.springaop.pildoras.lesson_3.aspect;

import com.example.springaop.pildoras.lesson_3.domain.Client;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 @Order annotation allows you to specify the order of aspect's execution.
 */
@Order(3)
@Aspect
@Component
public class LoginWithAspect {


  @Pointcut("execution(* com.example.springaop.pildoras.lesson_3.dao.*.*(..))")
  public void toClients() {}

  @Pointcut("execution(java.util.List com.example.springaop..lesson_3.dao.ClientDAO.findAll(..))")
  private void toClientFindAll() {}

  @Before("toClients()")
  public void beforeToSaveClient() {
    System.out.println("El usuario está registrado");
    System.out.println("El perfil para insertar clientes es correcto");
  }

  /*
    Capture returned value and then you can modify this content
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @AfterReturning(value = "toClientFindAll()", returning = "result")
  public void taskAfterFindAllClients(Object result) {
    List<Client> clientList = new ArrayList<>();
    if(result instanceof List list) {
      clientList = (List<Client>) list.stream()
          .filter(o -> o instanceof Client)
          .toList();
    }
    for(Client client : clientList) {
      if (client.getType().equalsIgnoreCase("vip")) {
        // modifying content
        String dataProcessed = "V:I:P" + client.getName().toUpperCase();
        client.setName(dataProcessed);
        System.out.println(STR."Existen clientes VIP en el listado. Nombre: \{client.getName()}");
      }
    }
  }

  /*
    Capture returned exception after throwing this.
   */
  @AfterThrowing(value = "toClientFindAll()", throwing = "throwable")
  public void taskAfterThrowingFindAllClients(Throwable throwable) {
    if(throwable instanceof NullPointerException exception) {
      System.out.println("I am a null pointer exception");
    }
    System.out.println(STR."The message error is: \{throwable.getMessage()}");
  }

}
