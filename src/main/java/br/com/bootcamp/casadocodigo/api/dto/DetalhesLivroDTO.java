package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Livro;
import lombok.Getter;

import java.math.BigDecimal;

public class DetalhesLivroDTO {

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
    private DetalhesAutorDTO detalhesAutor;

    public DetalhesLivroDTO(Livro livro){
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isnb = livro.getIsnb();
        this.detalhesAutor = new DetalhesAutorDTO(livro.getAutor());
    }
}
