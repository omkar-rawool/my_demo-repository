package com.crossasyst.controller;

import com.crossasyst.model.PersonRequest;
import com.crossasyst.model.PersonResponse;
import com.crossasyst.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonController {


    private final PersonService personService;

    @GetMapping(path = "/persons/{id}")
    public PersonResponse getById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping(path = "/persons")
    public PersonResponse[] getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping(path = "/persons")
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest personRequest) {
        return new ResponseEntity<>(personService.createPerson(personRequest), HttpStatus.CREATED);
    }

    @PutMapping("persons/{personId}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable Long personId, @RequestBody PersonRequest personRequest) {
        return new ResponseEntity<>(personService.updatePerson(personId, personRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("persons/{personId}")
    public void deletePerson(@PathVariable Long personId) {
        personService.deletePerson(personId);
    }

    @PatchMapping("persons/{personId}")
    public ResponseEntity<PersonResponse>
    patchFirstName(@PathVariable long personId, @RequestParam String firstName) {
        return new ResponseEntity<>(personService.patchFirstName(personId, firstName), HttpStatus.OK);
    }




}
