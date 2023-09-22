package br.ifsul.writerscircle.security.service;

import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private static String MENSAGEM_USUARIO_NAO_ENCONTRADO = "Usuário não encontrado";
    public Usuario buscar(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isPresent()){
            return usuario.get();
        } else throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_USUARIO_NAO_ENCONTRADO);
    }
}
