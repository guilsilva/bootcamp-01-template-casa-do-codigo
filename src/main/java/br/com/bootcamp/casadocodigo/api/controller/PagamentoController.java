package br.com.bootcamp.casadocodigo.api.controller;

import br.com.bootcamp.casadocodigo.api.dto.DadosCompraDTO;
import br.com.bootcamp.casadocodigo.api.form.DadosCompraForm;
import br.com.bootcamp.casadocodigo.domain.model.DadosCompra;
import br.com.bootcamp.casadocodigo.domain.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/pagamento")
//4
public class PagamentoController {

    //1
    @Autowired
    CupomRepository cupomRepository;
    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional
    //1
    //1
    public ResponseEntity<DadosCompraDTO> comprar(@RequestBody @Valid DadosCompraForm form,
                                                         UriComponentsBuilder uriComponentsBuilder){
        //1
        DadosCompra dadosCompra = form.get(entityManager, cupomRepository);
        entityManager.persist(dadosCompra);
        URI uri = uriComponentsBuilder.path("/api/pagamento/{id}").buildAndExpand(dadosCompra.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosCompraDTO(dadosCompra));
    }
}
