package com.example.springaop.pildoras.lesson_4;

import com.example.springaop.pildoras.lesson_4.domain.Person;
import com.example.springaop.pildoras.lesson_4.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example.springaop.pildoras.lesson_4"})
@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

  @Autowired
  private AppService appService;

  public static void main(String[] args) {
    SpringApplication.run(SpringAopApplication.class,args);
  }

  @Override
  public void run(String... args) throws Exception {
    this.appService.savePerson(3L, Person.of(3L, "george"));
    System.out.println("End application");
  }
}
