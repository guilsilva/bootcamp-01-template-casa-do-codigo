package br.com.bootcamp.casadocodigo.domain.model;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    private String nome;
    @Getter
    private String email;
    @Getter
    @Column(length = 400)
    private String descricao;
    @Getter
    private LocalDateTime dataRegistro;

    @Deprecated
    public Autor(){
    }

    public Autor(String nome, String email, String descricao, LocalDateTime dataRegistro) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
    }
}
