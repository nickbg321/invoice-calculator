package com.dt.invoicecalculator.currency.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = OutputCurrencyDefinedValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface OutputCurrencyDefined {

  String message() default "Output currency is not defined in the currencies list";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
