package br.com.bootcamp.casadocodigo.api.dto;

import br.com.bootcamp.casadocodigo.domain.model.DadosCompra;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

public class DadosCompraDTO {
    @Getter
    private String nome;
    @Getter
    private String email;
    @Getter
    private String sobrenome;
    @Getter
    private String documento;
    @Getter
    private String endereco;
    @Getter
    private String complemento;
    @Getter
    private String cidade;
    @Getter
    private PaisDTO pais;
    @Getter
    private EstadoDTO estado;
    @Getter
    private String telefone;
    @Getter
    private String cep;
    @Getter
    private CompraDTO compra;

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
