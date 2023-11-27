package br.ifsul.writerscircle.repository;

import br.ifsul.writerscircle.domain.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    List<Genero> findAllByNomeContainsIgnoreCase(String nome);
}
