package br.ifsul.writerscircle.security.service;

import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetUsuarioAutenticadoService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario get(){
        Usuario context = (Usuario) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return usuarioRepository.findById(context.getId()).get();
    }

}
