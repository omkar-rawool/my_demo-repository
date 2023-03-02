package com.mapping.demo.validator;

import com.mapping.demo.annotation.MobValidation;
import com.mapping.demo.model.PersonRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobValidator implements ConstraintValidator<MobValidation, PersonRequest> {

    @Override
    public boolean isValid(PersonRequest personRequest, ConstraintValidatorContext constraintValidatorContext) {
        if (personRequest.isMobileNumberPresent()) {
            return personRequest.getPhoneNumber() != null;
        }
        return true;
    }
}
