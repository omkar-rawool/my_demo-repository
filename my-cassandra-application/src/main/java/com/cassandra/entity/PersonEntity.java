package com.cassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "person")
public class PersonEntity {
    @PrimaryKey
    private UUID id=UUID.randomUUID();

    private String firstName;

    private String lastName;

    private String rollNo;
}
