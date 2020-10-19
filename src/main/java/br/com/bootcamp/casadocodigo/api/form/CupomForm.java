package br.com.bootcamp.casadocodigo.api.form;

import br.com.bootcamp.casadocodigo.api.validator.UniqueValue;
import br.com.bootcamp.casadocodigo.domain.model.Cupom;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
//1
public class CupomForm {

    @Getter
    @UniqueValue(domainClass = Cupom.class, fieldName = "codigo")
    @NotBlank(message = "{not.blank}")
    private String codigo;
    @Getter
    @NotNull(message = "{not.blank}")
    @Positive(message = "{not.negative}")
    private BigDecimal percentualDesconto;
    @Getter
    @Future(message = "{future}")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate validade;
    //1
    public Cupom get(){
        return new Cupom(codigo, percentualDesconto, validade);
    }
}
