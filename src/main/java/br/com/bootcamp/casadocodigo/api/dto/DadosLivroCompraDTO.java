package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.Livro;
import lombok.Getter;

import java.math.BigDecimal;

public class DadosLivroCompraDTO {
    @Getter
    private Long id;
    @Getter
    private String titulo;
    @Getter
    private BigDecimal preco;

    public DadosLivroCompraDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.preco = livro.getPreco();
    }
}
