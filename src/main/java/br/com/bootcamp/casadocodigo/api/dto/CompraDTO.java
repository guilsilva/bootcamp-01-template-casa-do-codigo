package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Compra;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import javax.persistence.ElementCollection;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//2
public class CompraDTO {
    @Getter
    private final BigDecimal total;
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final BigDecimal totalComDesconto;
    @ElementCollection
    //1
    private final Set<ItensCompraDTO> itens = new HashSet<>();

    //1
    public CompraDTO(Compra compra){
        this.total = compra.getTotal();
        this.totalComDesconto = compra.calculaTotalCompraComDesconto();
        this.itens.addAll(compra.getItens()
                .stream().map(ItensCompraDTO::new).collect(Collectors.toSet()));
    }
}
