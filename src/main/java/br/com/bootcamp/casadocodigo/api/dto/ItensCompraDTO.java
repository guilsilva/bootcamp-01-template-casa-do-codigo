package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.ItensCompra;
import lombok.Getter;

import java.math.BigDecimal;
//2
public class ItensCompraDTO {
    @Getter
    //1
    private final DadosLivroCompraDTO livro;
    @Getter
    private final Integer quantidade;
    @Getter
    private final BigDecimal precoItem;

    //1
    public ItensCompraDTO(ItensCompra itensCompra) {
        this.livro = new DadosLivroCompraDTO(itensCompra.getLivro());
        this.quantidade = itensCompra.getQuantidade();
        this.precoItem = livro.getPreco();
    }
}
