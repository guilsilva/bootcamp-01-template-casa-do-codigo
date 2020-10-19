package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Pais;
import lombok.Getter;
//1
public class PaisDTO {
    @Getter
    private final Long id;
    @Getter
    private final String nome;

    //1
    public PaisDTO(Pais pais){
        this.id = pais.getId();
        this.nome = pais.getNome();
    }
}
