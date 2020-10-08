package br.com.bootcamp.casadocodigo.api.form;

import br.com.bootcamp.casadocodigo.api.validator.UniqueValue;
import br.com.bootcamp.casadocodigo.domain.model.Autor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
//1
public class AutorForm {

    @Getter
    @Email(message = "{email.not.valid}")
    @NotBlank(message = "{not.blank}")
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @Getter
    @NotBlank(message = "{not.blank}")
    private String nome;
    @Getter
    @NotBlank(message = "{not.blank}")
    @Size(max = 400, message = "{descricao.size}")
    private String descricao;

    //1
    public Autor get(){
        return new Autor(this.nome, this.email, this.descricao);
    }
}
