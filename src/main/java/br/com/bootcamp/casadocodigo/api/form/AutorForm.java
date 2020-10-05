package br.com.bootcamp.casadocodigo.api.form;

import br.com.bootcamp.casadocodigo.api.validator.UniqueValue;
import br.com.bootcamp.casadocodigo.domain.model.Autor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
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
    @Getter
    @Builder.Default
    private LocalDateTime dataRegistro = LocalDateTime.now();

    //1
    public Autor get(){
        return new Autor(this.nome, this.email, this.descricao, this.dataRegistro);
    }
}
