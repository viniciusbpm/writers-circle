package br.ifsul.writerscircle.validator;

import br.ifsul.writerscircle.domain.SolicitacaoAmizade;
import br.ifsul.writerscircle.security.domain.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class ValidarSolicitacaoJaEnviadaValidator {
    public static final String MENSAGEM_SOLICITACAO_JA_ENVIADA = "Já existe uma solicitação entre esses dois usuários";
    public void validar(Usuario remetente, Usuario destinatario){
        Optional<SolicitacaoAmizade> solicitacao = destinatario.getSolicitacoes().stream()
                .filter(solicitacaoAmizade -> solicitacaoAmizade.getRemetente().equals(remetente)).findFirst();

        if(solicitacao.isPresent()){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_SOLICITACAO_JA_ENVIADA);
        }
    }
}
