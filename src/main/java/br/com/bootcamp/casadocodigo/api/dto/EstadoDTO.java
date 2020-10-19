package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Estado;
import lombok.Getter;
//2
public class EstadoDTO {
    @Getter
    private final Long id;
    @Getter
    private final String nome;
    @Getter
    //1
    private final PaisDTO pais;

    //1
    public EstadoDTO(Estado estado){
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = new PaisDTO(estado.getPais());
    }
}
