package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Autor;
import lombok.Getter;

import java.time.LocalDate;
//1
public class AutorDTO {

    @Getter
    private final Long id;
    @Getter
    private final String nome;
    @Getter
    private final String email;
    @Getter
    private final String descricao;
    @Getter
    private final LocalDate dataRegistro;

    //1
    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataRegistro = autor.getDataRegistro();
    }
}
