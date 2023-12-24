package com.example.springaop.pildoras.lesson_4.repository;

import com.example.springaop.pildoras.lesson_4.domain.Person;
import java.util.List;
import java.util.Optional;

public interface AppRepository {

  List<Person> findAll();

  Optional<Person> findById(Long id);

  void savePerson(Person newPerson);

}
