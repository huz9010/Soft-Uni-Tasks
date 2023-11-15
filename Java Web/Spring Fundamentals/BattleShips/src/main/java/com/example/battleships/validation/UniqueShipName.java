package com.example.battleships.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueShipNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface UniqueShipName {

    String message() default "Ship name is already in use";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
