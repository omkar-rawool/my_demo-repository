package com.mapping.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;

//    @OneToOne(mappedBy = "address")
//    private PersonEntity person;

    @OneToOne(mappedBy = "address")
    @PrimaryKeyJoinColumn
    private PersonEntity person;
}
