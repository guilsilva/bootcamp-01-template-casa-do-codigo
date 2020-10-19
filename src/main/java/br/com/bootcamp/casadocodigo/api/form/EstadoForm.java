package br.com.bootcamp.casadocodigo.api.form;

import br.com.bootcamp.casadocodigo.api.validator.ExistentField;
import br.com.bootcamp.casadocodigo.api.validator.UniqueValue;
import br.com.bootcamp.casadocodigo.domain.model.Estado;
import br.com.bootcamp.casadocodigo.domain.model.Pais;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoForm {

    @Getter
    @NotBlank(message = "{not.blank}")
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;
    @Getter
    @NotNull(message = "{not.blank}")
    @ExistentField(domainClass = Pais.class, fieldName = "id")
    private Long pais;

    public Estado get(EntityManager entityManager){
        return new Estado(nome, entityManager.find(Pais.class, pais));
    }
}
