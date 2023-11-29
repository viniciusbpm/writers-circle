package br.ifsul.writerscircle.security.repository;

import br.ifsul.writerscircle.domain.Genero;
import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByUsername(String username);
    @Query("select distinct u from Usuario u where (u.username != :username)" +
            " and ((u.livroFavorito = :livro) " +
            "or (u.escritorFavorito = :autor))")
    Page<Usuario> sugerirAmigos(String username, String autor, String livro, Pageable pageable);

}
