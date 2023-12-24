package com.example.springaop.pildoras.lesson_4.repository.impl;

import com.example.springaop.pildoras.lesson_4.domain.Person;
import com.example.springaop.pildoras.lesson_4.repository.AppRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class AppRepositoryImpl implements AppRepository {

  private static final List<Person> personList;

  static {
    personList = new ArrayList<>(Arrays.asList(
        Person.of(1L,"sue"),
        Person.of(2L, "ana")
    ));
  }

  @Override
  public List<Person> findAll() {
    System.out.println("executing findAll logic on repository");
    return personList;
  }

  @Override
  public Optional<Person> findById(Long id) {
    System.out.println("executing findById logic on repository");
    return personList.stream()
        .filter(person -> person.getId().equals(id))
        .findFirst();
  }

  @Override
  public void savePerson(Person newPerson) {
    System.out.println("executing savePerson logic on repository");
    personList.add(newPerson);
  }

}
