package com.example.springaop.pildoras.lesson_2.dao;

import com.example.springaop.pildoras.lesson_2.domain.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientDAO {

  public void saveClient(Client client) {
    System.out.println("Trabajo realizado OK. Cliente insertado con éxito.");
  }

}