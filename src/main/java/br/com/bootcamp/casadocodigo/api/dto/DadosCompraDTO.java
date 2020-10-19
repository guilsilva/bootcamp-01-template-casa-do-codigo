package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.DadosCompra;
import lombok.Getter;
//4
public class DadosCompraDTO {
    @Getter
    private final String nome;
    @Getter
    private final String email;
    @Getter
    private final String sobrenome;
    @Getter
    private final String documento;
    @Getter
    private final String endereco;
    @Getter
    private final String complemento;
    @Getter
    private final String cidade;
    @Getter
    //1
    private final PaisDTO pais;
    @Getter
    //1
    private final EstadoDTO estado;
    @Getter
    private final String telefone;
    @Getter
    private final String cep;
    @Getter
    //1
    private final CompraDTO compra;

    //1
    public DadosCompraDTO(DadosCompra dadosCompra){
        this.cep = dadosCompra.getCep();
        this.cidade = dadosCompra.getCidade();
        this.complemento = dadosCompra.getComplemento();
        this.compra = new CompraDTO(dadosCompra.getCompra());
        this.documento = dadosCompra.getDocumento();
        this.email = dadosCompra.getEmail();
        this.endereco = dadosCompra.getEndereco();
        this.estado = new EstadoDTO(dadosCompra.getEstado());
        this.pais = new PaisDTO(dadosCompra.getPais()); 
        this.telefone = dadosCompra.getTelefone();
        this.nome = dadosCompra.getNome();
        this.sobrenome = dadosCompra.getSobrenome();
    }
}
