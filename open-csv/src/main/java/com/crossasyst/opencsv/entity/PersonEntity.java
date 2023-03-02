package com.crossasyst.opencsv.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PersonEntity {
    @Id
    @SequenceGenerator(name = "seq_person_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_person_id")
    private Long id;
    private String firstName;
    private String lastName;

    public PersonEntity(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }
}