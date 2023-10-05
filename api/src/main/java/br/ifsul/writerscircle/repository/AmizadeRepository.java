package br.ifsul.writerscircle.repository;

import br.ifsul.writerscircle.domain.Amizade;
import br.ifsul.writerscircle.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AmizadeRepository extends JpaRepository<Amizade, Long> {
    Optional<Amizade> findByPrimeiroUsuarioAndSegundoUsuario(Usuario primeiroUsuario, Usuario segundoUsuario);
    Optional<Amizade> findByPrimeiroUsuario_IdAndSegundoUsuario_Id(Long primeiroUsuarioId, Long segundoUsuarioId);
    List<Amizade> findAllByPrimeiroUsuarioOrSegundoUsuario(Usuario primeiroUsuario, Usuario segundoUsuario);
}
