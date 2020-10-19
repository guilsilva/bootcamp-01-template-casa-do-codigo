package br.com.bootcamp.casadocodigo.api.form;

import br.com.bootcamp.casadocodigo.api.validator.ExistentField;
import br.com.bootcamp.casadocodigo.domain.model.Livro;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ItensCompraForm {
    @Getter
    @NotNull(message = "{not.blank}")
    @ExistentField(domainClass = Livro.class, fieldName = "id")
    private Long idLivro;
    @Getter
    @NotNull(message = "{not.blank}")
    @Positive(message = "{not.negative}")
    private Integer quantidade;
}
