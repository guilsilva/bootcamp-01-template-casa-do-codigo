package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Autor;
import lombok.Getter;
//1
public class DetalhesAutorDTO {
    @Getter
    private final String nome;
    @Getter
    private final String descricao;

    //1
    public DetalhesAutorDTO(Autor autor){
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }
}
