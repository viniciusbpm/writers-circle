package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    private static final String MENSAGEM_REVIEW_NAO_EXISTE = "Review não encontrada";
    public Review porId(Long id){
        Optional<Review> review = reviewRepository.findById(id);

        if(review.isEmpty()){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_REVIEW_NAO_EXISTE);
        }

        return review.get();
    }
}
