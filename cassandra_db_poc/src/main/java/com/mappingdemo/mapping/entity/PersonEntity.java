package com.mappingdemo.mapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {
    @PrimaryKey
    private Long personId;


    private String firstName;


    private String lastName;

    private String rollNo;

}
