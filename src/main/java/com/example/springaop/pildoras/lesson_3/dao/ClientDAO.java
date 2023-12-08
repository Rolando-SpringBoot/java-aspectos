package com.example.springaop.pildoras.lesson_3.dao;

import com.example.springaop.pildoras.lesson_3.domain.Client;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;

@Component
public class ClientDAO {

  public List<Client> findAll(boolean myParam) {
    System.out.println("Obteniendo la conexión de la base de datos...");
    try {
      TimeUnit.SECONDS.sleep(4);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
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