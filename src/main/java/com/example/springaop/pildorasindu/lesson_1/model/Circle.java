package com.example.springaop.pildorasindu.lesson_1.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Circle {

  private String name;

  public void setName(final String name) {
    System.out.println("Circle's setter called");
    this.name = name;
    throw new NullPointerException("nulidad");
  }

  public String setNameAndReturn(final String name) {
    this.name = name;
    System.out.println("Circle's setter called");
    return name;
  }

}
