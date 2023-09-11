package br.ifsul.writerscircle.security.service;

import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ValidarUsernameUnicoService {
    public static final String USERNAME_EM_USO = "Esse nome de usuário já está em uso";
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(String username){
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);

        if(usuario.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, USERNAME_EM_USO);
        }
    }
}
