package br.com.bootcamp.casadocodigo.domain.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    private String codigo;
    @Getter
    private BigDecimal percentualDesconto;
    @Getter
    private LocalDate validade;

    @Deprecated
    public Cupom(){}

    public Cupom(String codigo, BigDecimal percentualDesconto, LocalDate validade){
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
        this.validade = validade;
    }

    public void atualizar(Cupom cupom){
        this.codigo = cupom.getCodigo();
        this.validade = cupom.getValidade();
        this.percentualDesconto = cupom.getPercentualDesconto();
    }
}
