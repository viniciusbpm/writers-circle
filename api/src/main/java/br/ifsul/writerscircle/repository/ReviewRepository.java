package br.ifsul.writerscircle.repository;

import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByUsuarioEqualsOrderByDataPublicacao(Usuario usuario);
    @Query("select distinct r from Review r where (r.usuario IN :amigos)")
    Page<Review> findReviewsAmigos(List<Usuario> amigos, Pageable pageable);
}
