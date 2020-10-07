package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Autor;
import br.com.bootcamp.casadocodigo.domain.model.Categoria;
import br.com.bootcamp.casadocodigo.domain.model.Livro;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

//2
public class LivroDTO {

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
    @Getter
    private AutorDTO autor;
    //1
    @Getter
    private CategoriaDTO categoria;

    public LivroDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isnb = livro.getIsnb();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor = new AutorDTO(livro.getAutor());
        this.categoria = new CategoriaDTO(livro.getCategoria());
    }

    public static List<LivroDTO> converter(List<Livro> livros){
        return livros.stream().map(LivroDTO::new).collect(Collectors.toList());
    }
}
