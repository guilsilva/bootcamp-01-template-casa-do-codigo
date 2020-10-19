package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Cupom;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
//1
public class CupomDTO {
    @Getter
    private final Long id;
    @Getter
    private final String codigo;
    @Getter
    private final BigDecimal percentualDesconto;
    @Getter
    private final LocalDate validade;

    //1
    public CupomDTO(Cupom cupom){
        this.id = cupom.getId();
        this.codigo = cupom.getCodigo();
        this.percentualDesconto = cupom.getPercentualDesconto();
        this.validade = cupom.getValidade();
    }
}
