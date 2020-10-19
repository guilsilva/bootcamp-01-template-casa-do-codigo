package br.com.bootcamp.casadocodigo.api.form;

import br.com.bootcamp.casadocodigo.api.validator.ExistentField;
import br.com.bootcamp.casadocodigo.domain.model.ItensCompra;
import br.com.bootcamp.casadocodigo.domain.model.Livro;
import lombok.Getter;
import org.springframework.data.jpa.domain.AbstractPersistable_;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.stream.Collectors;

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
