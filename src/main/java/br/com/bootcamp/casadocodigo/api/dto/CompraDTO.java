package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Compra;
import br.com.bootcamp.casadocodigo.domain.model.ItensCompra;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import javax.persistence.ElementCollection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CompraDTO {
    @Getter
    private BigDecimal total;
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal totalComDesconto;
    @ElementCollection
    private Set<ItensCompraDTO> itens = new HashSet<>();

    public CompraDTO(Compra compra){
        this.total = compra.getTotal();
        this.totalComDesconto = compra.calculaTotalCompraComDesconto();
        this.itens.addAll(montaSetItensCompraDTO(compra.getItens()));
    }

    public Set<ItensCompraDTO> montaSetItensCompraDTO(Set<ItensCompra> itensCompra){
        return itensCompra.stream().map(item -> new ItensCompraDTO(item)).collect(Collectors.toSet());
    }
}
