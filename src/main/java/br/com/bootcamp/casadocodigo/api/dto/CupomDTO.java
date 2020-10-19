package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.api.validator.UniqueValue;
import br.com.bootcamp.casadocodigo.domain.model.Cupom;
import lombok.Getter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CupomDTO {
    @Getter
    private Long id;
    @Getter
    private String codigo;
    @Getter
    private BigDecimal percentualDesconto;
    @Getter
    private LocalDate validade;

    public CupomDTO(Cupom cupom){
        this.id = cupom.getId();
        this.codigo = cupom.getCodigo();
        this.percentualDesconto = cupom.getPercentualDesconto();
        this.validade = cupom.getValidade();
    }
}
