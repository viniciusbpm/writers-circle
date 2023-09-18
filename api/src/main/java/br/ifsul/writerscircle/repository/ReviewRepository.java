package br.ifsul.writerscircle.repository;

import br.ifsul.writerscircle.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
