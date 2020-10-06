package br.com.bootcamp.casadocodigo.api.controller;

import br.com.bootcamp.casadocodigo.api.dto.LivroDTO;
import br.com.bootcamp.casadocodigo.api.form.LivroForm;
import br.com.bootcamp.casadocodigo.domain.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/livro")
//3
public class LivroController {
    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional
    //1
    //1
    public ResponseEntity<LivroDTO> cadastrarLivro(@RequestBody @Valid LivroForm form){
        //1
        Livro livro = form.get(entityManager);
        entityManager.persist(livro);
        return ResponseEntity.ok(new LivroDTO(livro));
    }
}
