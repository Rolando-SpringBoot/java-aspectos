package com.example.springaop.pildorasindu.lesson_1.service;

import com.example.springaop.pildorasindu.lesson_1.model.Circle;
import com.example.springaop.pildorasindu.lesson_1.model.Triangle;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class ShapeService {

  @Autowired
  private Circle circle;
  @Autowired
  private Triangle triangle;

}
