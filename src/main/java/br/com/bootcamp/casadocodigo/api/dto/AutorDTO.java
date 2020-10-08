package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Autor;
import lombok.Getter;

import java.time.LocalDate;
//1
public class AutorDTO {

    @Getter
    private Long id;
    @Getter
    private String nome;
    @Getter
    private String email;
    @Getter
    private String descricao;
    @Getter
    private LocalDate dataRegistro;

    //1
    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataRegistro = autor.getDataRegistro();
    }
}
