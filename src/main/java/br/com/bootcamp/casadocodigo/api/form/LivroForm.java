package br.com.bootcamp.casadocodigo.api.form;

import br.com.bootcamp.casadocodigo.api.validator.ExistentField;
import br.com.bootcamp.casadocodigo.api.validator.UniqueValue;
import br.com.bootcamp.casadocodigo.domain.model.Autor;
import br.com.bootcamp.casadocodigo.domain.model.Categoria;
import br.com.bootcamp.casadocodigo.domain.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

//3
public class LivroForm {

    @Getter
    @NotBlank(message = "{not.blank}")
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @Getter
    @NotBlank(message = "{not.blank}")
    @Size(max = 500, message = "{resumo.size}")
    private String resumo;
    @Getter
    private String sumario;
    @Getter
    @NotNull(message = "{not.blank}")
    @PositiveOrZero(message = "{not.negative}")
    @Min(value = 20, message = "{preco.size}")
    private BigDecimal preco;
    @Getter
    @NotNull(message = "{not.blank}")
    @Min(message = "{paginas.size}", value = 100)
    private Integer numeroPaginas;
    @Getter
    @NotNull(message = "{not.blank}")
    @UniqueValue(domainClass = Livro.class, fieldName = "isnb")
    private Long isnb;
    @Getter
    @Future(message = "{future}")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @Getter
    @NotNull(message = "{not.blank}")
    @ExistentField(domainClass = Autor.class, fieldName = "id")
    private Long autor;
    @Getter
    @NotNull(message = "{not.blank}")
    @ExistentField(domainClass = Categoria.class, fieldName = "id")
    private Long categoria;

    //1
    public Livro get(EntityManager entityManager){
        return new Livro(titulo,resumo,sumario,preco,numeroPaginas,isnb,dataPublicacao,
                entityManager.find(Autor.class, autor),
                entityManager.find(Categoria.class, categoria));
    }
}
