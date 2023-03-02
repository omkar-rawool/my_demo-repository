package com.mapping.demo.service;

import com.mapping.demo.mapper.PersonMapper;
import com.mapping.demo.entity.PersonEntity;
import com.mapping.demo.exception.CannotCreatePersonException;
import com.mapping.demo.exception.NoPersonsAvailableException;
import com.mapping.demo.exception.PersonNotFoundException;
import com.mapping.demo.repository.PersonRepository;
import com.mapping.demo.model.PatchRequest;
import com.mapping.demo.model.PersonRequest;
import com.mapping.demo.model.PersonResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;

@Log4j2
@Service
@RequiredArgsConstructor
public class PersonService {

    private  final PersonRepository personRepository;

    private final PersonMapper personMapper;



    public PersonResponse createPerson(PersonRequest personRequest) {

        try {
            PersonEntity personEntity = personMapper.modelToEntity(personRequest);
            personRepository.save(personEntity);


            return personMapper.entityToModel(personEntity);
    }catch(Exception e){
            throw new CannotCreatePersonException("Cannot crate a resource..");
        }
    }

    public PersonResponse getPersonById(Long personId) {


        return personRepository.findById(personId).map(this::getPerson).orElseThrow(() -> new PersonNotFoundException("Person can not be found with id: " + personId));


    }

    private PersonResponse getPerson(PersonEntity personEntity) {
        return personMapper.entityToModel(personEntity);
    }

    public List<PersonResponse> getAllPersons() {
         try {
             List<PersonEntity> personEntity = personRepository.findAll();
             List<PersonResponse> personResponses = personMapper.modelToEntities(personEntity);
             log.info("Persons Fetched Successfully at " + new Date().toString());
             return personResponses;
         }catch (Exception e){
             throw new NoPersonsAvailableException("No records found");
         }
    }

    public void DeleteById(Long personId) {
        PersonEntity personEntity = personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException("Person can not be found with id " + personId));
        personRepository.delete(personEntity);
    }

    public PersonResponse updatePerson(Long personId, PersonRequest personRequest) {


        PersonEntity personEntity1 = personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException("Person can not be found with id " + personId));
        PersonEntity personEntity = personMapper.modelToEntity(personRequest);

        personEntity.getAddress().setAddressId(personEntity1.getAddress().getAddressId());
        personEntity.setPersonId(personId);
        personRepository.save(personEntity);
        return personMapper.entityToModel(personEntity);

    }


    public PersonResponse updatePersonName(Long id, PatchRequest patchRequest) {
        PersonEntity personEntity = personRepository.findById(id).get();
        personEntity.setFirstName(patchRequest.getFirstName());
        personRepository.save(personEntity);
        return personMapper.entityToModel(personEntity);

    }


    public PersonResponse patchFirstName(Long personId, String firstName) {
        PersonEntity personEntity = personRepository.findById(personId).get();
        personEntity.setFirstName(firstName);
        personRepository.save(personEntity);
        return personMapper.entityToModel(personEntity);
    }
}
