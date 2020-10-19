package br.com.bootcamp.casadocodigo.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
    String message() default "{unique.value}";
    String fieldName();
    Class<?> domainClass();
}