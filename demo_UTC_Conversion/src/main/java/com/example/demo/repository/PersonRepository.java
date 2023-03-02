package com.example.demo.repository;

import com.example.demo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity,Long> {

    public PersonEntity findByZoneId(String zoneId);

    public List<PersonEntity> findByCurrentLocalDateTimeInUTCBetween(LocalDateTime beginningDate,LocalDateTime endingDate);
}
