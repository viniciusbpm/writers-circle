package br.ifsul.writerscircle.repository;

import br.ifsul.writerscircle.domain.Desafio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DesafioRepository extends JpaRepository<Desafio, Long> {
    List<Desafio> findAllByDataFinalAfterAndAprovado(LocalDateTime dataFinal, boolean aprovado);
}
