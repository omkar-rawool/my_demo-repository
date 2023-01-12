package com.crossasyst.cassandra.model;

import com.crossasyst.cassandra.entity.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRequest {

    private String firstName;

    private String lastName;

    private String rollNo;
    private Status status;
}
