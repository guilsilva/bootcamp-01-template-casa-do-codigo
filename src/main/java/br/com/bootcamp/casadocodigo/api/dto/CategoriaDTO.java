package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Categoria;
import lombok.Getter;
//1
public class CategoriaDTO {

    @Getter
    private String nome;

    //1
    public CategoriaDTO(Categoria categoria){
        this.nome = categoria.getNome();
    }
}
