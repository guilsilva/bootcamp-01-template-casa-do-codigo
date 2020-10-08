package br.com.bootcamp.casadocodigo.domain.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    private String nome;

    @Deprecated
    public Pais(){}

    public Pais(String nome){
        this.nome = nome;
    }
}
