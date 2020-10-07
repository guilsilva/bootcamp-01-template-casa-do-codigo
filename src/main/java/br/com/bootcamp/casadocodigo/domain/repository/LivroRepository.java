package br.com.bootcamp.casadocodigo.domain.repository;

import br.com.bootcamp.casadocodigo.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
