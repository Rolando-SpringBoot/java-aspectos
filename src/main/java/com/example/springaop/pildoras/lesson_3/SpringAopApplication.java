package com.example.springaop.pildoras.lesson_3;

import com.example.springaop.pildoras.lesson_3.dao.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example.springaop.pildoras.lesson_3"})
@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

  @Autowired
  private ClientDAO clientDAO;

  public static void main(String[] args) {
    SpringApplication.run(SpringAopApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    this.clientDAO.findAll();
    System.out.println("Aquí continuaría la ejecución del programa");
  }

}