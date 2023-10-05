package br.ifsul.writerscircle.repository;

import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByUsuarioEquals(Usuario usuario);
}
