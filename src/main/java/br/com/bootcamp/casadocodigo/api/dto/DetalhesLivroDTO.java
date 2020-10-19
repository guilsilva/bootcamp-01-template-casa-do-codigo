package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Livro;
import lombok.Getter;

import java.math.BigDecimal;
//2
public class DetalhesLivroDTO {

    @Getter
    private final String titulo;
    @Getter
    private final String resumo;
    @Getter
    private final String sumario;
    @Getter
    private final BigDecimal preco;
    @Getter
    private final Integer numeroPaginas;
    @Getter
    private final Long isnb;
    @Getter
    //1
    private final DetalhesAutorDTO detalhesAutor;

    //1
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
