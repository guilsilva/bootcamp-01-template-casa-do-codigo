package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Autor;
import lombok.Getter;

public class DetalhesAutorDTO {
    @Getter
    private String nome;
    @Getter
    private String descricao;

    @Deprecated
    public DetalhesAutorDTO(){}

    public DetalhesAutorDTO(Autor autor){
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }
}
