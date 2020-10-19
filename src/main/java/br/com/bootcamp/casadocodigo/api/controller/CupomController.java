package br.com.bootcamp.casadocodigo.api.controller;

import br.com.bootcamp.casadocodigo.api.dto.CupomDTO;
import br.com.bootcamp.casadocodigo.api.form.CupomForm;
import br.com.bootcamp.casadocodigo.api.handler.ErrorMessage;
import br.com.bootcamp.casadocodigo.domain.model.Cupom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/api/cupom")
//5
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
    public ResponseEntity<?> atualizarCupom(@PathVariable Long id, @RequestBody @Valid CupomForm form){
        Cupom cupom = entityManager.find(Cupom.class, id);
        //1
        if(cupom == null){
            Collection<String> mensagens = new ArrayList<>();
            mensagens.add("Cupom informado não existe no sistema.");
            //1
            ErrorMessage errorMessage = new ErrorMessage(mensagens);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        cupom.atualizar(form.get());
        return ResponseEntity.ok().body(new CupomDTO(cupom));
    }
}
