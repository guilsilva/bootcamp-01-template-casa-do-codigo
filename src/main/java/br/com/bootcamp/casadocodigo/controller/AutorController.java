package br.com.bootcamp.casadocodigo.controller;

import br.com.bootcamp.casadocodigo.dto.AutorDTO;
import br.com.bootcamp.casadocodigo.form.AutorForm;
import br.com.bootcamp.casadocodigo.model.Autor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDTO> cadastrarAutor(@RequestBody @Valid AutorForm form, UriComponentsBuilder uriBuilder){
        AutorDTO autorDto = new AutorDTO(form.getAutor());

        URI uri = uriBuilder.path("autor/{id}").buildAndExpand(autorDto.getId()).toUri();

    }
}
