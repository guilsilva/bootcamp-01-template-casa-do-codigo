package br.com.bootcamp.casadocodigo.api.form;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

public class FluxoPagamentoForm {
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
    @Pattern(regexp = "((^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$)|(^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$))",
            message = "{format.invalid.cpf.cnpj}")
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
    @NotBlank(message = "{not.blank}")
    private String pais;
    @Getter
    @NotBlank(message = "{not.blank}")
    private String estado;
    @Getter
    @NotBlank(message = "{not.blank}")
    private String telefone;
    @Getter
    @NotBlank(message = "{not.blank}")
    @Pattern(regexp = "^\\d{5}\\-\\d{3}$", message = "{format.invalid.cep}")
    private String cep;
}
