package br.com.bootcamp.casadocodigo.domain.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

