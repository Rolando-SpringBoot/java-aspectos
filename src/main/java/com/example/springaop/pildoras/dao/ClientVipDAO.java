package com.example.springaop.pildoras.dao;

import org.springframework.stereotype.Component;

@Component
public class ClientVipDAO {

  public void saveClientVip() {
    System.out.println("Trabajo realizado OK. Cliente VIP insertado con éxito");
  }

}
