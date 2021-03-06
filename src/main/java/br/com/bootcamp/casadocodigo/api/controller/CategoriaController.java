package br.com.bootcamp.casadocodigo.api.controller;

import br.com.bootcamp.casadocodigo.api.dto.CategoriaDTO;
import br.com.bootcamp.casadocodigo.api.form.CategoriaForm;
import br.com.bootcamp.casadocodigo.domain.model.Categoria;
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
@RequestMapping("/api/categoria")
//3
public class CategoriaController {

    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional
    //1
    //1
    public ResponseEntity<CategoriaDTO> cadastrarCategoria(@RequestBody @Valid CategoriaForm form){
        //1
        Categoria categoria = form.get();
        entityManager.persist(categoria);
        return ResponseEntity.ok(new CategoriaDTO(categoria));
    }
}
