package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Categoria;
import lombok.Getter;

public class CategoriaDTO {
    @Getter
    private Long id;

    @Getter
    private String nome;

    public CategoriaDTO(Categoria categoria){
        this.nome = categoria.getNome();
        this.id = categoria.getId();
    }
}
