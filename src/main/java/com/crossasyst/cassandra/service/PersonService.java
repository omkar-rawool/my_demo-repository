package com.crossasyst.cassandra.service;

import com.crossasyst.cassandra.entity.PersonEntity;
import com.crossasyst.cassandra.mapper.PersonMapper;
import com.crossasyst.cassandra.model.PersonRequest;
import com.crossasyst.cassandra.model.PersonResponse;
import com.crossasyst.cassandra.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }


    public List<PersonResponse> findAll() {
        return personMapper.entitiesToModel(personRepository.findAll());
    }

    public PersonResponse findPersonById(UUID id) {

        return personMapper.entityToModel(personRepository.findById(id).get());
    }

    public PersonResponse createPerson(PersonRequest personRequest) {
        PersonEntity personEntity = personMapper.modelToEntity(personRequest);
        personEntity.setDateTimeStamp(new Date());
        personEntity.setRegistrationDate(LocalDate.now());
        personRepository.save(personEntity);


        return personMapper.entityToModel(personEntity);
    }

    public PersonResponse getByLastName(String lastName) {
        PersonEntity personEntity = personRepository.getByLastName(lastName);
        return personMapper.entityToModel(personEntity);

    }

    public void deletePerson(UUID id) {
        personRepository.deleteById(id);

    }

    public void deletPersonByLastName(String lastName) {

        personRepository.deleteByLastName(lastName);
    }
}
