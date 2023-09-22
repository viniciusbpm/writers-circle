package br.ifsul.writerscircle.validator;

import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.security.domain.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ValidarUsuarioDonoReviewValidator {
    public static final String MENSAGEM_USUARIO_NAO_E_DONO_REVIEW = "Você não tem permissão para alterar esta review";
    public void validar(Usuario usuario, Review review){
        if(!review.getUsuario().equals(usuario)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, MENSAGEM_USUARIO_NAO_E_DONO_REVIEW);
        }
    }
}
