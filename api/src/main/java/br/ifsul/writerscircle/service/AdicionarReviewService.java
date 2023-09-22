package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.request.ReviewRequest;
import br.ifsul.writerscircle.controller.response.ReviewResponse;
import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.repository.ReviewRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import br.ifsul.writerscircle.validator.ValidarNotaReviewValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.ifsul.writerscircle.mapper.ReviewMapper.toEntity;
import static br.ifsul.writerscircle.mapper.ReviewMapper.toResponse;
import static java.time.LocalDateTime.now;

@Service
public class AdicionarReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;

    @Autowired
    private ValidarNotaReviewValidator validarNotaReviewValidator;

    @Transactional
    public ReviewResponse adicionar(ReviewRequest request){
        validarNotaReviewValidator.validar(request.getNota());
        Usuario usuario = getUsuarioAutenticadoService.get();
        Review review = toEntity(request);

        review.setDataPublicacao(now());
        review.setUsuario(usuario);

        usuario.adicionarReview(review);

        reviewRepository.save(review);

        return toResponse(review);
    }
}
