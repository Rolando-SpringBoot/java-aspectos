package com.example.springaop.pildoras.lesson_3.aspect;

import com.example.springaop.pildoras.lesson_3.domain.Client;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.annotation.AfterReturning;
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

  @Pointcut("execution(* com.example.springaop.pildoras.lesson_3.dao.ClientDAO.findAll())")
  private void toClientFindAll() {}

  @SuppressWarnings({"unchecked", "rawtypes"})
  @AfterReturning(value = "toClientFindAll()", returning = "result")
  public void taskAfterFindClients(Object result) {
    List<Client> clientList = new ArrayList<>();
    if(result instanceof List list) {
      clientList = (List<Client>) list.stream()
          .filter(o -> o instanceof Client)
          .toList();
    }
    for(Client client : clientList) {
      if (client.getType().equalsIgnoreCase("vip")) {
        System.out.println(STR."Existen clientes VIP en el listado. Nombre: \{client.getName()}");
      }
    }
  }

  @Before("toClients()")
  public void beforeToSaveClient() {
    System.out.println("El usuario está registrado");
    System.out.println("El perfil para insertar clientes es correcto");
  }

}
