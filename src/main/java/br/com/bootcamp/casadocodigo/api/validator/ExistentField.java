package br.com.bootcamp.casadocodigo.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistentFieldValidator.class})
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistentField {
    String message() default "{not.existent.value}";
    String fieldName();
    Class<?> domainClass();
}
