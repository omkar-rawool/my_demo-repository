package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class PersonEntity {
    @Id
    @SequenceGenerator(name = "seq_person_id", initialValue = 1, allocationSize = 1) //sequenceName = "seq_person_id",
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person_id")
    private Long id;

    private String name;



    private String zoneId;


    private LocalDateTime currentLocalDateTimeInUTC;

}
