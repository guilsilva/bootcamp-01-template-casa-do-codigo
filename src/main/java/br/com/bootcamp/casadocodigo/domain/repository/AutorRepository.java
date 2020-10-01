package br.com.bootcamp.casadocodigo.domain.repository;

import br.com.bootcamp.casadocodigo.domain.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);
}
