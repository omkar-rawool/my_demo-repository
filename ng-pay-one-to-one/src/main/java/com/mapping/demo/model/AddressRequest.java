package com.mapping.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
}
