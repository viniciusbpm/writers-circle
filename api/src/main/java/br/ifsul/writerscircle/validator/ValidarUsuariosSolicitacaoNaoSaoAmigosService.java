package br.ifsul.writerscircle.validator;

import br.ifsul.writerscircle.domain.Amizade;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.service.BuscarAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidarUsuariosSolicitacaoNaoSaoAmigosService {
    @Autowired
    private BuscarAmizadeService buscarAmizadeService;
    public static final String MENSAGEM_USUARIOS_JA_SAO_AMIGOS = "Estes dois usuários já são amigos";

    public void validar(Usuario remetente, Usuario destinatario){
        Amizade amizade = buscarAmizadeService.porUsuarios(remetente, destinatario);

        if(amizade != null) {
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_USUARIOS_JA_SAO_AMIGOS);
        }
    }
}
