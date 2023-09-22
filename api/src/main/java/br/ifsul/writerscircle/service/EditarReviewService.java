package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.request.ReviewRequest;
import br.ifsul.writerscircle.controller.response.ReviewResponse;
import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.repository.ReviewRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import br.ifsul.writerscircle.validator.ValidarUsuarioDonoReviewValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.ifsul.writerscircle.mapper.ReviewMapper.toResponse;

@Service
public class EditarReviewService {
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ValidarUsuarioDonoReviewValidator validarUsuarioDonoReviewValidator;
    @Autowired
    private BuscarReviewService buscarReviewService;

    public ReviewResponse editar(ReviewRequest request, Long idReview){
        Usuario usuario = getUsuarioAutenticadoService.get();
        Review review = buscarReviewService.porId(idReview);

        validarUsuarioDonoReviewValidator.validar(usuario, review);

        review.setNota(request.getNota());
        review.setConteudo(request.getConteudo());
        review.setImagem(request.getImagem());
        review.setTitulo(request.getTitulo());
        review.setObraAvaliada(request.getObraAvaliada());

        reviewRepository.save(review);

        return toResponse(review);
    }
}
