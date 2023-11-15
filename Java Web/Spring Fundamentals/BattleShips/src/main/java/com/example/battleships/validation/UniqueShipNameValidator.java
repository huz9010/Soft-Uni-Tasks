package com.example.battleships.validation;

import com.example.battleships.service.ShipService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueShipNameValidator implements ConstraintValidator<UniqueShipName, String> {

    private final ShipService shipService;

    public UniqueShipNameValidator(ShipService shipService) {
        this.shipService = shipService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.shipService.findByName(value);
    }
}
