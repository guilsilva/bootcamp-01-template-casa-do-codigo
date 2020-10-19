package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Livro;
import lombok.Getter;

import java.math.BigDecimal;
//1
public class DadosLivroCompraDTO {
    @Getter
    private final Long id;
    @Getter
    private final String titulo;
    @Getter
    private final BigDecimal preco;

    //1
    public DadosLivroCompraDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.preco = livro.getPreco();
    }
}
