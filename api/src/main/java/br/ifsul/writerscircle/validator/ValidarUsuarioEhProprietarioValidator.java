package br.ifsul.writerscircle.validator;

import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.security.domain.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ValidarUsuarioEhProprietarioValidator {
    public static final String MENSAGEM_USUARIO_NAO_E_DONO = "Você não tem permissão para alterar isto";
    public void validar(Long idUsuarioLogado, Long idDono){
        if(!idUsuarioLogado.equals(idDono)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, MENSAGEM_USUARIO_NAO_E_DONO);
        }
    }
}
