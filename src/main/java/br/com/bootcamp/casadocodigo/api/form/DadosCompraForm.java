package br.com.bootcamp.casadocodigo.api.form;

import br.com.bootcamp.casadocodigo.api.validator.ExistentField;
import br.com.bootcamp.casadocodigo.domain.model.DadosCompra;
import br.com.bootcamp.casadocodigo.domain.model.Estado;
import br.com.bootcamp.casadocodigo.domain.model.Pais;
import br.com.bootcamp.casadocodigo.domain.repository.CupomRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DadosCompraForm {
    @Getter
    @NotBlank(message = "{not.blank}")
    private String nome;
    @Getter
    @Email(message = "{email.not.valid}")
    @NotBlank(message = "{not.blank}")
    private String email;
    @Getter
    @NotBlank(message = "{not.blank}")
    private String sobrenome;
    @Getter
    @NotBlank(message = "{not.blank}")
    @Pattern(regexp = "((^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$)|(^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$))",
            message = "{format.invalid.cpf.cnpj}")
    @JsonFormat(pattern = "xxx.xxx.xxx-xx or xx.xxx.xxx/xxxx-xx", shape = JsonFormat.Shape.STRING)
    private String documento;
    @Getter
    @NotBlank(message = "{not.blank}")
    private String endereco;
    @Getter
    @NotBlank(message = "{not.blank}")
    private String complemento;
    @Getter
    @NotBlank(message = "{not.blank}")
    private String cidade;
    @Getter
    @NotNull(message = "{not.blank}")
    @ExistentField(domainClass = Pais.class, fieldName = "id")
    private Long pais;
    @Getter
    @NotNull(message = "{not.blank}")
    @ExistentField(domainClass = Estado.class, fieldName = "id")
    private Long estado;
    @Getter
    @NotBlank(message = "{not.blank}")
    private String telefone;
    @Getter
    @NotBlank(message = "{not.blank}")
    @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "{format.invalid.cep}")
    @JsonFormat(pattern = "xxxxx-xxx", shape = JsonFormat.Shape.STRING)
    private String cep;
    @Getter
    @NotNull(message = "{not.blank}")
    @Valid
    private CompraForm compraForm;

    public DadosCompra get(EntityManager entityManager, CupomRepository cupomRepository){
        return new DadosCompra(nome, email, sobrenome, documento, endereco, complemento, cidade,
                entityManager.find(Pais.class, pais),
                entityManager.find(Estado.class, estado), telefone, cep,
                compraForm.get(entityManager, cupomRepository));
    }
}
