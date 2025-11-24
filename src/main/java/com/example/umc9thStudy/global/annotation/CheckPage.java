package com.example.umc9thStudy.global.annotation;

import com.example.umc9thStudy.global.validator.CheckPageValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target( {ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "페이지의 값은 1이상의 정수입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
