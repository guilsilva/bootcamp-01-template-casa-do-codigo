package br.com.bootcamp.casadocodigo.api.controller;

import br.com.bootcamp.casadocodigo.ErrorMessage;
import br.com.bootcamp.casadocodigo.api.dto.AutorDTO;
import br.com.bootcamp.casadocodigo.api.form.AutorForm;
import br.com.bootcamp.casadocodigo.api.validator.ProibeEmailDuplicadoAutorValidator;
import br.com.bootcamp.casadocodigo.domain.model.Autor;
import br.com.bootcamp.casadocodigo.domain.repository.AutorRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/api/autor")
public class AutorController {
    //1
    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        //1
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping
    @Transactional
    //1
    //1
    public ResponseEntity<AutorDTO> cadastrarAutor(@RequestBody @Valid AutorForm form){
        //1
        Autor autor = form.get();
        autorRepository.save(autor);
        return ResponseEntity.ok(new AutorDTO(autor));
    }
}
