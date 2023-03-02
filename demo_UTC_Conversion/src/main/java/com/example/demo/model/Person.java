package com.example.demo.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
public class Person {
    private String name;

    private String zoneId;

    private LocalDateTime  currentLocalDateTimeInUTC;

}
