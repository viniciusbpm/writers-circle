package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.response.ReviewResponse;
import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.ifsul.writerscircle.mapper.ReviewMapper.toResponse;

@Service
public class DetalherReviewService {
    @Autowired
    private BuscarReviewService buscarReviewService;

    public ReviewResponse detalhar(Long idReview){
        Review review = buscarReviewService.porId(idReview);

        return toResponse(review);
    }
}
