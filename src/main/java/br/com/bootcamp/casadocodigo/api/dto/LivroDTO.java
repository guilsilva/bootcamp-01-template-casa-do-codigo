package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Livro;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

//3
public class LivroDTO {

    @Getter
    private final Long id;
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
    private final LocalDate dataPublicacao;
    //1
    @Getter
    private final AutorDTO autor;
    //1
    @Getter
    private final CategoriaDTO categoria;

    //1
    public LivroDTO(Livro livro) {
        this.id = livro.getId();
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
