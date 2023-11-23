package br.ifsul.writerscircle.repository;

import br.ifsul.writerscircle.domain.Frase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraseRepository extends JpaRepository<Frase, Long> {
}
