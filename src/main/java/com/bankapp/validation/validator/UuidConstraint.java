package com.bankapp.validation.validator;

import com.bankapp.validation.annotation.UuidCheck;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Shilov Maxim
 */

public class UuidConstraint implements ConstraintValidator<UuidCheck, UUID> {

    private static final String UUID_PATTERN =
            "^[\\da-fA-F]{8}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{12}$";

    @Override
    public void initialize(UuidCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UUID uuid, ConstraintValidatorContext context) {
        return Optional.ofNullable(uuid)
                .filter(s -> !s.toString().isBlank())
                .map(s -> s.toString().matches(UUID_PATTERN))
                .orElse(false);
    }
}
