package br.com.bootcamp.casadocodigo.api.form;

import br.com.bootcamp.casadocodigo.api.validator.CupomValid;
import br.com.bootcamp.casadocodigo.domain.model.Compra;
import br.com.bootcamp.casadocodigo.domain.model.Cupom;
import br.com.bootcamp.casadocodigo.domain.model.ItensCompra;
import br.com.bootcamp.casadocodigo.domain.model.Livro;
import br.com.bootcamp.casadocodigo.domain.repository.CupomRepository;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
//3
public class CompraForm {
    @Getter
    @NotNull(message = "{not.blank}")
    @Valid
    //1
    private final Set<ItensCompraForm> itensCompra = new HashSet<>();
    @Getter
    @CupomValid(domainClass = Cupom.class, fieldName = "codigo")
    private String cupomDesconto;

    //1
    public Compra get(EntityManager entityManager, CupomRepository cupomRepository){
        return new Compra(montaSetItensCompra(entityManager), cupomRepository.findByCodigo(cupomDesconto));
    }

    //1
    public Set<ItensCompra> montaSetItensCompra(EntityManager entityManager){
        return itensCompra.stream().map(
                itensCompraForm ->
                        new ItensCompra(entityManager.find(Livro.class, itensCompraForm.getIdLivro()),
                                itensCompraForm.getQuantidade())).collect(Collectors.toSet());
    }
}
