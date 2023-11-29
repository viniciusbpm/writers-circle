package br.ifsul.writerscircle.security.service;

import br.ifsul.writerscircle.security.controller.response.UsuarioResumidoResponse;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.mapper.UsuarioResumidoMapper;
import br.ifsul.writerscircle.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SugerirAmigosService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;
    public Page<UsuarioResumidoResponse> sugerir(Pageable pageable){
        Usuario usuario = getUsuarioAutenticadoService.get();

        return usuarioRepository.sugerirAmigos(usuario.getUsername(), usuario.getEscritorFavorito()
                , usuario.getLivroFavorito(),
                pageable).map(UsuarioResumidoMapper::toResponse);
    }
}
