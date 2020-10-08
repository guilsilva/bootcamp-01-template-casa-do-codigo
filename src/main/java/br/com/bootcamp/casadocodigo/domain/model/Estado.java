package br.com.bootcamp.casadocodigo.domain.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String nome;
    @Getter
    @ManyToOne
    @JoinColumn
    private Pais pais;

    @Deprecated
    public Estado(){}

    public Estado(String nome, Pais pais){
        this.nome = nome;
        this.pais = pais;
    }
}
