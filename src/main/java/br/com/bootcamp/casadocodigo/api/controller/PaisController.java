package br.com.bootcamp.casadocodigo.api.controller;

import br.com.bootcamp.casadocodigo.api.dto.PaisDTO;
import br.com.bootcamp.casadocodigo.api.form.PaisForm;
import br.com.bootcamp.casadocodigo.domain.model.Pais;
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
@RequestMapping("/api/pais")
//3
public class PaisController {
    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional
    //1
    //1
    public ResponseEntity<PaisDTO> cadastrarPais(@RequestBody @Valid PaisForm paisForm){
        //1
        Pais pais = paisForm.get();
        entityManager.persist(pais);
        return ResponseEntity.ok(new PaisDTO(pais));
    }
}
