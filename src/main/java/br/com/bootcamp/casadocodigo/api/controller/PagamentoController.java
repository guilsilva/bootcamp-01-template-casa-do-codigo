package br.com.bootcamp.casadocodigo.api.controller;

import br.com.bootcamp.casadocodigo.api.dto.LivroDTO;
import br.com.bootcamp.casadocodigo.api.form.FluxoPagamentoForm;
import br.com.bootcamp.casadocodigo.api.form.LivroForm;
import br.com.bootcamp.casadocodigo.domain.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid FluxoPagamentoForm form){
        return ResponseEntity.ok("Esta tudo validado");
    }
}
