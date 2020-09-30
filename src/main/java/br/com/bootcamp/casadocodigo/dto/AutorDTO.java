package br.com.bootcamp.casadocodigo.dto;

import br.com.bootcamp.casadocodigo.model.Autor;
import lombok.Getter;

import java.net.URI;
import java.time.LocalDateTime;

public class AutorDTO {

    @Getter
    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dataRegistro;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataRegistro = autor.getDataRegistro();
    }
}
