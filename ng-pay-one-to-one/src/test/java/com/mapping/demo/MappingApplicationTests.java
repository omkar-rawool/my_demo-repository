package com.mapping.demo;

import com.mapping.demo.entity.AddressEntity;
import com.mapping.demo.entity.PersonEntity;
import com.mapping.demo.repository.PersonRepository;
import com.mapping.demo.model.PersonResponse;
import com.mapping.demo.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest

class MappingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private PersonService personService;

	@MockBean
	private PersonRepository personRepository;


	@BeforeEach
	void setUp()
	{
		Optional<PersonEntity> person = Optional.of(new PersonEntity(1l,"omkar","Rawool",new AddressEntity(4l,"abc","def","Mumbai","Maharashtra","36736",new PersonEntity())));
		Mockito.when(personRepository.findById(1l)).thenReturn(person);
	}
  @Test
	public void testGetPersonById()
  {
	  String firstName="omkar";
	  PersonResponse personById=personService.getPersonById(1l);
	  Assertions.assertEquals(firstName,personById.getFirstName());
  }


}
