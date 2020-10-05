package br.com.bootcamp.casadocodigo.api.controller;

import br.com.bootcamp.casadocodigo.api.dto.AutorDTO;
import br.com.bootcamp.casadocodigo.api.form.AutorForm;
import br.com.bootcamp.casadocodigo.domain.model.Autor;
import br.com.bootcamp.casadocodigo.domain.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/autor")
//4
public class AutorController {
    //1
    @Autowired
    private AutorRepository autorRepository;

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
