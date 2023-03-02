package com.example.demo.controller;

import com.example.demo.model.TimeJson;
import com.example.demo.service.PersonService;
import com.example.demo.entity.PersonEntity;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/persons")
    public ResponseEntity<PersonEntity> create(@RequestBody Person person){
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }

//    @GetMapping("/getTimeFromZoneId")
//    public ResponseEntity<TimeJson> getTimeFromZoneId(@RequestParam ZoneId zoneId){
//        return new ResponseEntity<>(personService.getTimeFromZoneId(zoneId),HttpStatus.OK);
//    }

   /* @GetMapping("/convert-to-utc")
    public String convertToUtc(@RequestParam("datetime") String datetime) {
        LocalDateTime localDateTime = LocalDateTime.parse(datetime);
      //  localDateTime.atZone(ZoneId.of("UTC"));
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        ZonedDateTime utcDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));

        return utcDateTime.toLocalDateTime().toString();
    }*/

    @GetMapping("/convert-to-utc")
    public String convertToUtc(@RequestParam("zoneId") String zoneId) {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of(zoneId));
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(zoneId));
        ZonedDateTime utcDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        return localDateTime.toString()+"<-----LocalDateTime  UTC Converted----> "+utcDateTime.toLocalDateTime().toString();
    }

    @GetMapping("/persons/zoneId")
    public List<PersonEntity> findRecordsByZoneId(@RequestParam String zoneId )
    {
        List<PersonEntity> personEntities = personService.findRecordsBasedOnZoneId(zoneId);

        return personEntities;
    }

}
