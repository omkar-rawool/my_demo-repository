package com.crossasyst.cassandra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "person")
public class PersonEntity {
    @PrimaryKey

    private UUID id = UUID.randomUUID();


    private String firstName;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED,ordinal = 0)
    private String lastName;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateTimeStamp;
    private LocalDate registrationDate;
    private Status status;


    private String rollNo;


}
