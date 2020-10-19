package br.com.bootcamp.casadocodigo.api.form;

import br.com.bootcamp.casadocodigo.api.validator.CupomValid;
import br.com.bootcamp.casadocodigo.api.validator.ExistentField;
import br.com.bootcamp.casadocodigo.domain.model.Compra;
import br.com.bootcamp.casadocodigo.domain.model.Cupom;
import br.com.bootcamp.casadocodigo.domain.model.ItensCompra;
import br.com.bootcamp.casadocodigo.domain.model.Livro;
import br.com.bootcamp.casadocodigo.domain.repository.CupomRepository;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CompraForm {
    @Getter
    @NotNull(message = "{not.blank}")
    @Valid
    private Set<ItensCompraForm> itensCompra = new HashSet<>();
    @Getter
    @CupomValid
    private String cupomDesconto;

    public Compra get(EntityManager entityManager, CupomRepository cupomRepository){
        return new Compra(montaSetItensCompra(entityManager), cupomRepository.findByCodigo(cupomDesconto));
    }

    public Set<ItensCompra> montaSetItensCompra(EntityManager entityManager){
        return itensCompra.stream().map(
                itensCompraForm ->
                        new ItensCompra(entityManager.find(Livro.class, itensCompraForm.getIdLivro()),
                                itensCompraForm.getQuantidade())).collect(Collectors.toSet());
    }
}
