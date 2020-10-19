package br.com.bootcamp.casadocodigo.domain.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
public class DadosCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    private String nome;
    @Getter
    private String email;
    @Getter
    private String sobrenome;
    @Getter
    private String documento;
    @Getter
    private String endereco;
    @Getter
    private String complemento;
    @Getter
    private String cidade;
    @Getter
    @ManyToOne
    private Pais pais;
    @Getter
    @ManyToOne
    private Estado estado;
    @Getter
    private String telefone;
    @Getter
    private String cep;
    @Getter
    @OneToOne(mappedBy = "dadosCompra", cascade = CascadeType.PERSIST)
    private Compra compra;

    @Deprecated
    public DadosCompra(){}

    public DadosCompra(String nome, String email, String sobrenome, String documento, String endereco,
                       String complemento, String cidade, Pais pais, Estado estado, String telefone,
                       String cep, Compra compra) {
        this.nome = nome;
        this.email = email;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
        this.compra = compra;
    }
}
