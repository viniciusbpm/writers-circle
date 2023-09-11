package br.ifsul.writerscircle.security.service;

import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ValidarEmailUnicoService {
    public static final String EMAIL_EM_USO = "Este endereço de email já está sendo usado";
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(String email){
        Optional<Usuario> user = usuarioRepository.findByEmail(email);

        if(user.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, EMAIL_EM_USO);
        }
    }
}
