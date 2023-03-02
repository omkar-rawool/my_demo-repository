package com.crossasyst.service;

import com.crossasyst.handler.MyExceptionHandler;
import com.crossasyst.model.PersonRequest;
import com.crossasyst.model.PersonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final RestTemplate restTemplate;
    @Value("${url}")
    String url;

    public PersonResponse getPersonById(Long personId) {
        restTemplate.setErrorHandler(new MyExceptionHandler());

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        HttpEntity<Object> entity = new HttpEntity<>(null, headers);
        ResponseEntity<PersonResponse> personResponse = restTemplate.exchange(url + "/persons/" + personId, HttpMethod.GET, entity, PersonResponse.class);

        personResponse.getStatusCode();

        return personResponse.getBody();


    }

    public PersonResponse[] getAllPersons() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");

        HttpEntity<Object> entity = new HttpEntity<>(null, headers);
        ResponseEntity<PersonResponse[]> personResponse = restTemplate.exchange(url + "/persons", HttpMethod.GET, entity, PersonResponse[].class);
        return personResponse.getBody();

    }


    public PersonResponse createPerson(PersonRequest personRequest) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        HttpEntity<PersonRequest> httpEntity = new HttpEntity<>(personRequest, headers);
        ResponseEntity<PersonResponse> person = restTemplate.exchange(url + "/persons", HttpMethod.POST, httpEntity, PersonResponse.class);

        return person.getBody();
    }

    public Void deletePerson(Long personId) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        HttpEntity<Object> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Void> personResponse = restTemplate.exchange(url + "/persons/" + personId, HttpMethod.DELETE, entity, Void.class);
        return personResponse.getBody();

    }


    public PersonResponse updatePerson(Long personId, PersonRequest personRequest) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        HttpEntity<PersonRequest> httpEntity = new HttpEntity<>(personRequest, headers);
        ResponseEntity<PersonResponse> person = restTemplate.exchange(url + "/persons/" + personId, HttpMethod.PUT, httpEntity, PersonResponse.class);

        return person.getBody();
    }


    public PersonResponse patchFirstName(long personId, String firstName) {

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        HttpEntity<Object> entity = new HttpEntity<>(firstName, headers);
        ResponseEntity<PersonResponse> personResponse = restTemplate.exchange(url + "/persons/" + personId + "?firstName=" + firstName, HttpMethod.PATCH, entity, PersonResponse.class);

        return personResponse.getBody();
    }
}
