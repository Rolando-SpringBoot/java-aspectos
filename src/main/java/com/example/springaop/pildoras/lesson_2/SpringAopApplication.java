package com.example.springaop.pildoras.lesson_2;

import com.example.springaop.pildoras.lesson_2.dao.ClientDAO;
import com.example.springaop.pildoras.lesson_2.dao.ClientVipDAO;
import com.example.springaop.pildoras.lesson_2.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example.springaop.pildoras.lesson_2"})
@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

  @Autowired
  private ClientDAO clientDAO;
  @Autowired
  private ClientVipDAO clientVipDAO;

  public static void main(String[] args) {
    SpringApplication.run(SpringAopApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Client clientUno = Client.of("Juan Díaz", "normal");
    clientDAO.saveClient(clientUno);
    clientVipDAO.saveClientVip();
  }

}
