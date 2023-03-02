package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class TimeJson {

    @Id
    private String name;

    private String zoneId;
    private LocalDateTime currentLocalDateTime;

    private LocalDateTime dateTimeSixMonthsAgo;


    private LocalDateTime currentLocalDateTimeInUTC;
    private LocalDateTime dateTimeSixMonthsAgoInUTC;

}
