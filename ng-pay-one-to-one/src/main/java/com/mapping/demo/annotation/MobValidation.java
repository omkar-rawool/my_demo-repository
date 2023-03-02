package com.mapping.demo.annotation;


import com.mapping.demo.validator.MobValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = MobValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER, ElementType.TYPE})
public  @interface MobValidation {

    public String message() default "Invalid selection:it must be true";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

}
