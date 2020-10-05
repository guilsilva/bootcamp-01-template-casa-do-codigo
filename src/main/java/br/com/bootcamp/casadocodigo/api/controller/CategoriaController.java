package br.com.bootcamp.casadocodigo.api.controller;

import br.com.bootcamp.casadocodigo.api.dto.CategoriaDTO;
import br.com.bootcamp.casadocodigo.api.form.CategoriaForm;
import br.com.bootcamp.casadocodigo.domain.model.Categoria;
import br.com.bootcamp.casadocodigo.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDTO> cadastrarCategoria(@RequestBody @Valid CategoriaForm form){
        Categoria categoria = form.get();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok(new CategoriaDTO(categoria));
    }
}
