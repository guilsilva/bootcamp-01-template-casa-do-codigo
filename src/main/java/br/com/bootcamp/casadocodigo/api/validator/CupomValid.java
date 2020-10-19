package br.com.bootcamp.casadocodigo.api.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CupomValidValidator.class})
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CupomValid {
    String message() default "{not.valid.value}";
}
