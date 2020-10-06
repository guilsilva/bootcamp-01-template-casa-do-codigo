package br.com.bootcamp.casadocodigo.domain.model;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
//2
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    private String titulo;
    @Getter
    private String resumo;
    @Getter
    private String sumario;
    @Getter
    private BigDecimal preco;
    @Getter
    private Integer numeroPaginas;
    @Getter
    private Long isnb;
    @Getter
    private LocalDate dataPublicacao;
    //1
    @ManyToOne
    @JoinColumn
    @Getter
    private Autor autor;
    //1
    @ManyToOne
    @JoinColumn
    @Getter
    private Categoria categoria;

    @Deprecated
    public Livro(){ }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco,
                 Integer numeroPaginas, Long isnb, LocalDate dataPublicacao,
                 Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isnb = isnb;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }
}
