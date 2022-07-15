package com.motorbikesshop.Config.CustomValidation.impl;

import com.motorbikesshop.Config.CustomValidation.UniqueEmailValidation;
import com.motorbikesshop.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidationImpl implements ConstraintValidator<UniqueEmailValidation, String> {


    private final UserRepository userRepository;

    public UniqueEmailValidationImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.userRepository.
                findByEmail(value).
                isEmpty();
    }
}
