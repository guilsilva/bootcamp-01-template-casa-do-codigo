package br.com.bootcamp.casadocodigo.api.validator;

import br.com.bootcamp.casadocodigo.api.form.AutorForm;
import br.com.bootcamp.casadocodigo.domain.model.Autor;
import br.com.bootcamp.casadocodigo.domain.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) return;

        AutorForm autorForm = (AutorForm) target;
        Optional<Autor> autorOptional = autorRepository.findByEmail(autorForm.getEmail());
        if(autorOptional.isPresent())
            errors.rejectValue("email",
                    null,
                    "Já existe um(a) outro(a) autor(a) com o mesmo email " + autorForm.getEmail());
    }
}
