package br.com.bootcamp.casadocodigo.domain.model;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;

@Embeddable
public class ItensCompra {

    @Getter
    @ManyToOne
    private Livro livro;
    @Getter
    private Integer quantidade;
    @Getter
    private BigDecimal totalItem;

    @Deprecated
    public ItensCompra(){}

    public ItensCompra(Livro livro, Integer quantidade){
        this.livro = livro;
        this.quantidade = quantidade;
        this.totalItem = new BigDecimal(livro.getPreco().doubleValue() * quantidade);
    }
}
