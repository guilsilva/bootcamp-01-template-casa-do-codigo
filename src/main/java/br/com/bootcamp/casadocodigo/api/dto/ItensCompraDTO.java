package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.ItensCompra;
import br.com.bootcamp.casadocodigo.domain.model.Livro;
import lombok.Getter;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

public class ItensCompraDTO {
    @Getter
    private DadosLivroCompraDTO livro;
    @Getter
    private Integer quantidade;
    @Getter
    private BigDecimal precoItem;

    public ItensCompraDTO(ItensCompra itensCompra) {
        this.livro = new DadosLivroCompraDTO(itensCompra.getLivro());
        this.quantidade = itensCompra.getQuantidade();
        this.precoItem = livro.getPreco();
    }
}
