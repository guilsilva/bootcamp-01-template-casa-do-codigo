package br.com.bootcamp.casadocodigo.domain.model;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    @OneToOne
    private DadosCompra dadosCompra;
    @Getter
    private BigDecimal total = new BigDecimal("0.0");
    @Getter
    @ManyToOne
    private Cupom cupom;
    @ElementCollection
    @Getter
    private final Set<ItensCompra> itens = new HashSet<>();

    @Deprecated
    public Compra(){}

    public Compra(Set<ItensCompra> itens, Cupom cupom){
        this.itens.addAll(itens);
        this.cupom = cupom;
        calculaTotalCompra(itens);
    }

    public void calculaTotalCompra(Set<ItensCompra> itens){
        itens.forEach(item -> total = total.add(item.getTotalItem()));
    }

    public BigDecimal calculaTotalCompraComDesconto() {
        if (cupom != null) {
            total = total.subtract(
                    total.divide(cupom.getPercentualDesconto(), RoundingMode.UP));
            return total;
        }
        return null;
    }
}
