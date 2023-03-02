package com.mapping.demo.controller;


import com.mapping.demo.model.PatchRequest;
import com.mapping.demo.model.PersonRequest;
import com.mapping.demo.model.PersonResponse;
import com.mapping.demo.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;


    @Operation(summary = "Create the person by using token", parameters = {@Parameter(in = ParameterIn.HEADER, name = "token")})

    @PostMapping(value = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createPerson(@RequestBody @Valid PersonRequest personRequest) {
        PersonResponse personResponse = personService.createPerson(personRequest);
        return new ResponseEntity<>(personResponse, HttpStatus.CREATED);
    }


    @Operation(summary = "Find the person by using personId", parameters = {@Parameter(in = ParameterIn.HEADER, name = "token")})

    @GetMapping(value = "/persons/id" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> getPersonById(@RequestAttribute Long personId)
    {
        PersonResponse personResponse= personService.getPersonById(personId);
        ResponseEntity<PersonResponse> responseEntity;
        if(Objects.nonNull(personResponse)) {
            responseEntity=new ResponseEntity<>(personResponse,HttpStatus.OK);
           // return new ResponseEntity<>(personResponse, HttpStatus.OK);
        }
        else
        {
            responseEntity=new ResponseEntity<>(personResponse, HttpStatus.NOT_FOUND);

        }
        System.out.println("Status Code"+responseEntity.getStatusCode());
        return responseEntity;

    }

    @GetMapping(value = "/persons" )
    public ResponseEntity<List<PersonResponse>> getAllPersons()
    {
        List<PersonResponse> personResponses = personService.getAllPersons();

        if(personResponses.isEmpty())
        {
            return new ResponseEntity<>(personResponses,HttpStatus.NO_CONTENT);
        }else
        return new ResponseEntity<>(personResponses,HttpStatus.OK);
    }

    @DeleteMapping(value = "/persons/{personId}")
    public  ResponseEntity<HttpStatus> DeleteById(@PathVariable Long personId )
    {
        personService.DeleteById(personId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/persons/{personId}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable Long personId , @RequestBody PersonRequest personRequest)
    {
        PersonResponse personResponse= personService.updatePerson(personId, personRequest);
        return new ResponseEntity<>(personResponse, HttpStatus.CREATED);
    }


    @PatchMapping(value = "/persons/{personId}" ,consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> patchPerson(@PathVariable Long personId, @RequestBody PatchRequest patchRequest)
    {

        PersonResponse personResponse = personService.updatePersonName(personId, patchRequest);

        return new ResponseEntity<>(personResponse,HttpStatus.CREATED);
    }


    @PatchMapping("persons/{personId}")
    public ResponseEntity<PersonResponse> patchFirstName(@PathVariable Long personId,@RequestParam (required = false) String firstName)
    {
        return new ResponseEntity<>(personService.patchFirstName(personId,firstName),HttpStatus.CREATED);

    }




/*


    @GetMapping(value = "/persons/{personId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> getPersonById(@PathVariable Long personId)
    {
        PersonResponse personResponse= personService.getPersonById(personId);
        ResponseEntity<PersonResponse> responseEntity;
        if(Objects.nonNull(personResponse)) {
            responseEntity=new ResponseEntity<>(personResponse,HttpStatus.OK);
            // return new ResponseEntity<>(personResponse, HttpStatus.OK);
        }
        else
        {
            responseEntity=new ResponseEntity<>(personResponse, HttpStatus.NOT_FOUND);

        }
        System.out.println("Status Code"+responseEntity.getStatusCode());
        return responseEntity;

    }




*/

}



