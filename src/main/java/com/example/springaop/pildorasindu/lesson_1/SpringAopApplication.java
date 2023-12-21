package com.example.springaop.pildorasindu.lesson_1;

import com.example.springaop.pildorasindu.lesson_1.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example.springaop.pildorasindu.lesson_1"})
@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

  @Autowired
  private ShapeService shapeService;

  public static void main(String... args) {
    SpringApplication.run(SpringAopApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    String name = this.shapeService.getTriangle().getName();
    System.out.println("name = " + name);
  }

}
