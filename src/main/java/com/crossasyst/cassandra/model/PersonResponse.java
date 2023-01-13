package com.crossasyst.cassandra.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class PersonResponse extends PersonRequest {

    private UUID id;
    private Date dateTimeStamp;
    private LocalDate registrationDate;

}
