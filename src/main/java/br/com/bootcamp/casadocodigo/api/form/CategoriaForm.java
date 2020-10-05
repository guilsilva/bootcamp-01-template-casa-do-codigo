package br.com.bootcamp.casadocodigo.api.form;

import br.com.bootcamp.casadocodigo.api.validator.UniqueValue;
import br.com.bootcamp.casadocodigo.domain.model.Categoria;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {
    @Getter
    @NotBlank(message = "{not.blank}")
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public Categoria get(){
        return new Categoria(this.nome);
    }
}
