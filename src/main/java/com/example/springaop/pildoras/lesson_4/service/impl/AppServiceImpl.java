package com.example.springaop.pildoras.lesson_4.service.impl;

import com.example.springaop.pildoras.lesson_4.annotation.Loggeable;
import com.example.springaop.pildoras.lesson_4.domain.Person;
import com.example.springaop.pildoras.lesson_4.repository.AppRepository;
import com.example.springaop.pildoras.lesson_4.service.AppService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {

  @Autowired
  AppRepository appRepository;

  @Override
  public List<Person> findAll() {
    System.out.println("executing findAll logic on service");
    return this.appRepository.findAll();
  }

  @Override
  public Person findById(Long id) {
    System.out.println("executing findById logic on service");
    return this.appRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("person doesn't exist"));
  }

  @Loggeable
  @Override
  public void savePerson(Long id, Person newPerson) {
    System.out.println("executing savePerson logic on service");
    Optional<Person> optPerson = this.appRepository.findById(id);
    if (optPerson.isPresent()) {
      throw new RuntimeException("person already exist");
    }
    this.appRepository.savePerson(newPerson);
  }

}
