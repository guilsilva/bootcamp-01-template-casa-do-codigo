package br.com.bootcamp.casadocodigo.api.form;

import br.com.bootcamp.casadocodigo.api.validator.UniqueValue;
import br.com.bootcamp.casadocodigo.domain.model.Pais;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @Getter
    @NotBlank(message = "{not.blank}")
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public Pais get(){
        return new Pais(nome);
    }
}
