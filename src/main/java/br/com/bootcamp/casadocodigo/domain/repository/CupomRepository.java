package br.com.bootcamp.casadocodigo.domain.repository;

import br.com.bootcamp.casadocodigo.domain.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CupomRepository extends JpaRepository<Cupom, Long> {
    Cupom findByCodigo(String codigo);
}
