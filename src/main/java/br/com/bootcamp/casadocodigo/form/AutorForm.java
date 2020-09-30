package br.com.bootcamp.casadocodigo.form;

import br.com.bootcamp.casadocodigo.model.Autor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class AutorForm {

    @Getter
    @NotNull @Email @NotEmpty
    private String email;
    @Getter
    @NotNull @NotEmpty
    private String nome;
    @Getter
    @NotNull @Size(max = 400) @NotEmpty
    private String descricao;
    @Getter
    @NotNull
    @Builder.Default
    private LocalDateTime dataRegistro = LocalDateTime.now();

    public Autor getAutor(){
        return new Autor(this.nome, this.email, this.descricao, this.dataRegistro);
    }
}
