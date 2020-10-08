package br.com.bootcamp.casadocodigo.api.controller;

import br.com.bootcamp.casadocodigo.api.dto.EstadoDTO;
import br.com.bootcamp.casadocodigo.api.form.EstadoForm;
import br.com.bootcamp.casadocodigo.domain.model.Estado;
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
@RequestMapping("/api/estado")
public class EstadoController {
    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoDTO> cadastrarEstado(@RequestBody @Valid EstadoForm estadoForm){
        Estado estado = estadoForm.get(entityManager);
        entityManager.persist(estado);
        return ResponseEntity.ok(new EstadoDTO(estado));
    }
}
