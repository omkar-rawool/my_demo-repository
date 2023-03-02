package com.example.demo.service;

import com.example.demo.entity.PersonEntity;
import com.example.demo.model.Person;
import com.example.demo.model.TimeJson;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

//    public TimeJson getTimeFromZoneId(ZoneId zoneId){
//       return new TimeJson(LocalDateTime.now(zoneId),LocalDateTime.now(zoneId).minusMonths(6L));
//    }

    /*private Object toUTCTimeConverter(ZoneId zoneId){
        LocalDateTime.now(ZoneId.of("UTC"));
    }*/

   /* private LocalDateTime getUTCtimeFromLocalDateTime(LocalDateTime localDateTime){

    }*/
    public PersonEntity createPerson(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(person.getName());
        personEntity.setZoneId(person.getZoneId());
      //  personEntity.setCurrentLocalDateTime(LocalDateTime.now(ZoneId.of(person.getZoneId())));
      //  personEntity.setDateTimeSixMonthsAgo(LocalDateTime.now(ZoneId.of(person.getZoneId())).minusMonths(6L));

        //LocalDateTime utc = LocalDateTime.now(ZoneId.of("UTC"));
        personEntity.setCurrentLocalDateTimeInUTC(person.getCurrentLocalDateTimeInUTC());
      //  personEntity.setDateTimeSixMonthsAgoInUTC(utc.minusMonths(6L));
        return personRepository.save(personEntity);

    }

    private LocalDateTime getUTCtimeFromLocalDateTime (LocalDateTime localDateTime, String zoneId){
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(zoneId));
        ZonedDateTime utcDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        return utcDateTime.toLocalDateTime();
    }

    public List<PersonEntity> findRecordsBasedOnZoneId(String zoneId) {
          LocalDateTime today = LocalDateTime.now(ZoneId.of(zoneId));
          LocalDateTime sixMonthBefore = today.minusMonths(6L);

        LocalDateTime utc = getUTCtimeFromLocalDateTime(today, zoneId);

        //ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"));  //UTC Conversion

        LocalDateTime sixMonthsBeforeUTC = utc.minusMonths(6L);


        return personRepository.findByCurrentLocalDateTimeInUTCBetween(sixMonthsBeforeUTC,utc);
    }


}
