package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Estado;
import br.com.bootcamp.casadocodigo.domain.model.Pais;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

public class EstadoDTO {
    @Getter
    private Long id;
    @Getter
    private String nome;
    @Getter
    private PaisDTO pais;

    public EstadoDTO(Estado estado){
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = new PaisDTO(estado.getPais());
    }
}
