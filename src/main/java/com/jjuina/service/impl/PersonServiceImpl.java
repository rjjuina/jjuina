package com.jjuina.service.impl;

import com.jjuina.model.Person;
import com.jjuina.service.PersonService;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Override
    public Person findPerson(int id) {
        return new Person(1, "JiaJun", 30, "male");
    }
}
