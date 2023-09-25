package br.ifsul.writerscircle.validator;

import br.ifsul.writerscircle.security.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class ValidarUsuariosSolicitacaoNaoSaoAmigosValidator {
    public static final String MENSAGEM_USUARIOS_JA_SAO_AMIGOS = "Estes dois usuários já são amigos";

    public void validar(Usuario remetente, Usuario destinatario){
        if(remetente.getAmigos().contains(destinatario)){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_USUARIOS_JA_SAO_AMIGOS);
        }
    }
}
