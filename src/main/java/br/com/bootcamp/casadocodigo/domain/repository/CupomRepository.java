package br.com.bootcamp.casadocodigo.domain.repository;

import br.com.bootcamp.casadocodigo.domain.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CupomRepository extends JpaRepository<Cupom, Long> {
    Cupom findByCodigo(String codigo);
}
