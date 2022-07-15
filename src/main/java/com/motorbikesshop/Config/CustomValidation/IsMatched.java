package com.motorbikesshop.Config.CustomValidation;

import com.motorbikesshop.Config.CustomValidation.impl.IsMatchedImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = IsMatchedImpl.class)
public @interface IsMatched {

    String first();

    String second();

    String message() default "Password must be match!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
