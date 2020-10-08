package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Pais;
import lombok.Getter;

public class PaisDTO {
    @Getter
    private Long id;
    @Getter
    private String nome;

    public PaisDTO(Pais pais){
        this.id = pais.getId();
        this.nome = pais.getNome();
    }
}
