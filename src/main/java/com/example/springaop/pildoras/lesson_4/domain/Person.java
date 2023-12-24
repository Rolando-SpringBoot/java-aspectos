package com.example.springaop.pildoras.lesson_4.domain;

import com.example.springaop.pildoras.lesson_4.annotation.Loggeable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Loggeable
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Person {

  private Long id;
  private String name;

  public Long getId() {
    System.out.println("Person's getter id called");
    return this.id;
  }

  public void setId(Long id) {
    System.out.println("Person's setter id called");
    this.id = id;
  }

  public String getName() {
    System.out.println("Person's getter name called");
    return this.name;
  }

  public void setName(String name) {
    System.out.println("Person's setter name called");
    this.name = name;
  }

}
