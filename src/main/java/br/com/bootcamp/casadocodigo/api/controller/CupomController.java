package br.com.bootcamp.casadocodigo.api.controller;

import br.com.bootcamp.casadocodigo.api.dto.CupomDTO;
import br.com.bootcamp.casadocodigo.api.form.CupomForm;
import br.com.bootcamp.casadocodigo.api.validator.ExistentField;
import br.com.bootcamp.casadocodigo.domain.model.Cupom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/cupom")
//4
public class CupomController {

    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional
    //1
    //1
    public ResponseEntity<CupomDTO> cadastrarCupom(@RequestBody @Valid CupomForm form){
        //1
        Cupom cupom = form.get();
        entityManager.persist(cupom);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CupomDTO(cupom));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CupomDTO> atualizarCupom(@PathVariable Long id, @RequestBody @Valid CupomForm form){
        Cupom cupom = entityManager.find(Cupom.class, id);
        //1
        if(cupom != null){
            cupom.atualizar(form.get());
            return ResponseEntity.ok().body(new CupomDTO(cupom));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CupomDTO(cupom));
    }
}
