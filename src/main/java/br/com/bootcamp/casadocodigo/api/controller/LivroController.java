package br.com.bootcamp.casadocodigo.api.controller;

import br.com.bootcamp.casadocodigo.api.handler.ErrorMessage;
import br.com.bootcamp.casadocodigo.api.dto.DetalhesLivroDTO;
import br.com.bootcamp.casadocodigo.api.dto.LivroDTO;
import br.com.bootcamp.casadocodigo.api.form.LivroForm;
import br.com.bootcamp.casadocodigo.domain.model.Livro;
import br.com.bootcamp.casadocodigo.domain.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/livro")
//6
public class LivroController {
    @Autowired
    EntityManager entityManager;

    @Autowired
    LivroRepository livroRepository;

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

    @GetMapping("/all")
    public ResponseEntity<List<LivroDTO>> consultarLivros(){
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(LivroDTO.converter(livros));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarLivroPorId(@PathVariable("id") Long id){
        Livro livro = entityManager.find(Livro.class, id);
        //1
        if(livro == null){
            //1
            List<String> erro = new ArrayList<>();
            erro.add("Id informado não existe no banco.");

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorMessage(erro));
        }
        //1
        return ResponseEntity.ok(new DetalhesLivroDTO(livro));
    }
}
