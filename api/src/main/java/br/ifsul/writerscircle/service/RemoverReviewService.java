package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.repository.ReviewRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import br.ifsul.writerscircle.validator.ValidarUsuarioEhProprietarioValidator;
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
    private ValidarUsuarioEhProprietarioValidator validarUsuarioEhProprietarioValidator;

    @Transactional
    public void remover(Long idReview){
        Usuario usuario = getUsuarioAutenticadoService.get();
        Review review = buscarReviewService.porId(idReview);

        validarUsuarioEhProprietarioValidator.validar(usuario.getId(), review.getId());

        reviewRepository.delete(review);

        usuario.removerReview(review);
    }
}
