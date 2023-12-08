package com.example.springaop.pildoras.lesson_3.dao;

import com.example.springaop.pildoras.lesson_3.domain.Client;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ClientDAO {

  public List<Client> findAll(boolean myParam) {
    if(myParam) throw new NullPointerException("It was not possible to get database connection!");
    // simulate clients returned by BBDD
    List<Client> clientList = List.of(
        Client.of("María", "normal"),
        Client.of("Ana", "vip"),
        Client.of("Sandra", "vip"),
        Client.of("Antonio", "normal")
    );
    System.out.println("Ejecución finalizada del método findAll()");
    return clientList;
  }

}