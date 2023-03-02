package com.mappingdemo.mapping.service;

import com.mappingdemo.mapping.entity.PersonEntity;
import com.mappingdemo.mapping.exception.ResourceNotFoundException;
import com.mappingdemo.mapping.mapper.PersonMapper;
import com.mappingdemo.mapping.model.PersonRequest;
import com.mappingdemo.mapping.model.PersonResponse;

import com.mappingdemo.mapping.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Log4j2
@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonResponse createPerson(PersonRequest personRequest) {
        PersonEntity personEntity = personMapper.modelToEntity(personRequest);
        personRepository.save(personEntity);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getPersonId());
        return personResponse;
    }

    public PersonResponse getPersonById(Long personId) {

        PersonEntity personEntity = personRepository.findById(personId).get();
        PersonResponse personResponse = personMapper.entityToModel(personEntity);

        return personResponse;
    }

    public List<PersonResponse> getAllPersons() {
        List<PersonEntity> personEntity = personRepository.findAll();
        List<PersonResponse> personResponses = personMapper.modelToEntities(personEntity);
        return personResponses;
    }

    public void DeleteById(Long personId) {
        personRepository.deleteById(personId);
    }


    public PersonResponse updatePerson(Long personId, PersonRequest personRequest) {
        PersonEntity personEntity = personRepository.findById(personId).orElseThrow(()->new ResourceNotFoundException("Person not present with id: "+personId));
        PersonEntity personEntity1 = personMapper.modelToEntity(personRequest);
        personEntity1.setPersonId(personId);
        personRepository.save(personEntity1);
        return personMapper.entityToModel(personEntity1);
    }

}
