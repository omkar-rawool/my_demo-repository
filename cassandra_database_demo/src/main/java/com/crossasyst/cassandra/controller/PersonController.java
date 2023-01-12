package com.crossasyst.cassandra.controller;

import com.crossasyst.cassandra.entity.PersonEntity;
import com.crossasyst.cassandra.model.PersonRequest;
import com.crossasyst.cassandra.model.PersonResponse;
import com.crossasyst.cassandra.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController

public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public ResponseEntity<List<PersonResponse>> getAllPersons() {

        return new ResponseEntity<>(personService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonResponse> getPersonById(@PathVariable UUID id) {
        return new ResponseEntity<>(personService.findPersonById(id), HttpStatus.FOUND);
    }

    @PostMapping("/persons")
    public ResponseEntity<PersonEntity> createPerson(@RequestBody PersonRequest personRequest) {
        return new ResponseEntity<>(personService.createPerson(personRequest), HttpStatus.CREATED);
    }

    @GetMapping("persons/lastname/{lastName}")
    public ResponseEntity<PersonResponse> getByLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(personService.getByLastName(lastName), HttpStatus.OK);
    }

    @DeleteMapping("persons/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable UUID id) {
        personService.deletePerson(id);
        return ResponseEntity.status(HttpStatus.OK).body("Person deleted with id:"+id);
    }

    @DeleteMapping("persons/lastname/{lastName}")
    public ResponseEntity<String> deletePersonByLastName(@PathVariable String lastName) {
        personService.deletPersonByLastName(lastName);
        return ResponseEntity.status(HttpStatus.OK).body("Person deleted with lastname: "+lastName);
    }

}
