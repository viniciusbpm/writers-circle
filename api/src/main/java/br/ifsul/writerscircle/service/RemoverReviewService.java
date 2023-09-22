package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.repository.ReviewRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.BuscarUsuarioService;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import br.ifsul.writerscircle.validator.ValidarUsuarioDonoReviewValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemoverReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;
    @Autowired
    private BuscarReviewService buscarReviewService;
    @Autowired
    private ValidarUsuarioDonoReviewValidator validarUsuarioDonoReviewValidator;

    @Transactional
    public void remover(Long idReview){
        Usuario usuario = getUsuarioAutenticadoService.get();
        Review review = buscarReviewService.porId(idReview);

        validarUsuarioDonoReviewValidator.validar(usuario, review);

        reviewRepository.delete(review);

        usuario.removerReview(review);
    }
}
