package com.example.springaop.pildoras.lesson_3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Client {
  private String name;
  private String type;

}
