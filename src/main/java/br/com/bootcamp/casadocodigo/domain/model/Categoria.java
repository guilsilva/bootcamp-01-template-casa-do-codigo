package br.com.bootcamp.casadocodigo.domain.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String nome;

    @Deprecated
    public Categoria(){}

    public Categoria(String nome){
        this.nome = nome;
    }
}

