package com.crossasyst.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
