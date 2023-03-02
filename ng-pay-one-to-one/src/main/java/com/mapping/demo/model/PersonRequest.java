package com.mapping.demo.model;

import com.mapping.demo.annotation.MobValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor


@MobValidation(message = "Mob num is necessary")
public class PersonRequest {

    @NotNull(message = "Username should not be null")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

        private AddressRequest address;
    private boolean isMobileNumberPresent;
    private String phoneNumber;
}
