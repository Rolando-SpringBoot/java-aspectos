package com.example.springaop.pildoras.lesson_1.dao;

import com.example.springaop.pildoras.lesson_1.domain.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientDAO {

  private String normalClientRating;
  private String normalClientCode;

  public void saveClient(Client client, String type) {
    System.out.println("Trabajo realizado OK. Cliente insertado con éxito.");
  }

  public String getNormalClientRating() {
    System.out.println("Obteniendo valuación del cliente normal");
    return this.normalClientRating;
  }

  public void setNormalClientRating(String normalClientRating) {
    System.out.println("Estableciendo el valor de la valuación del cliente normal");
    this.normalClientRating = normalClientRating;
  }

  public String getNormalClientCode() {
    System.out.println("Obteniendo el valor del código del cliente normal");
    return this.normalClientCode;
  }

  public void setNormalClientCode(String normalClientCode) {
    System.out.println("Estableciendo el valor del código del cliente normal");
    this.normalClientCode = normalClientCode;
  }

}