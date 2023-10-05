package br.ifsul.writerscircle.repository;

import br.ifsul.writerscircle.domain.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Long> {
}
