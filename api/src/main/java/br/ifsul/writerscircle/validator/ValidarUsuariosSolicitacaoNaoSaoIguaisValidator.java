package br.ifsul.writerscircle.validator;

import br.ifsul.writerscircle.security.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class ValidarUsuariosSolicitacaoNaoSaoIguaisValidator {
    public static final String MENSAGEM_USUARIOS_SOLICITACAO_IGUAIS =
            "Não é possível enviar solicitações para si mesmo";
    public void validar(Usuario remetente, Usuario destinatario){
        if(remetente.equals(destinatario)){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_USUARIOS_SOLICITACAO_IGUAIS);
        }
    }
}
