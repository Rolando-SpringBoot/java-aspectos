package com.example.springaop.pildoras.lesson_4.service;

import com.example.springaop.pildoras.lesson_4.domain.Person;
import java.util.List;

public interface AppService {

  List<Person> findAll();
  Person findById(Long id);
  void savePerson(Long id, Person newPerson);

}
