package com.crossasyst.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    private Long studentId;
    private String firstName;

    private String lastName;

    private String status;
}
