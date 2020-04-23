package com.jjuina.controller.rest;

import com.jjuina.controller.CarController;
import com.jjuina.model.Person;
import com.jjuina.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    public static Logger log = LoggerFactory.getLogger(CarController.class);

    @Autowired
    PersonService personService;

    @RequestMapping(value = "person/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPersonInfo(@PathVariable("id") int id) {
        log.info("rest request started");
        Person person = personService.findPerson(id);

        if (person == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
}
