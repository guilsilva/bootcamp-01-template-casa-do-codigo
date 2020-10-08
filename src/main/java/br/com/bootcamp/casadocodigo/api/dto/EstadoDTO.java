package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Estado;
import br.com.bootcamp.casadocodigo.domain.model.Pais;
import lombok.Getter;

public class EstadoDTO {
    @Getter
    private Long id;
    @Getter
    private String nome;
    @Getter
    private Pais pais;

    public EstadoDTO(Estado estado){
        this.nome = estado.getNome();
        this.pais = estado.getPais();
    }
}
