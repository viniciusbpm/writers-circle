package br.ifsul.writerscircle.security.service;

import br.ifsul.writerscircle.security.controller.response.UsuarioResponse;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.ifsul.writerscircle.security.mapper.UsuarioMapper.toResponse;

@Service
public class VisualizarDetalhesPerfilService {
    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    public UsuarioResponse visualizar(Long idUsuario){
        Usuario usuario = buscarUsuarioService.porId(idUsuario);

        return toResponse(usuario);
    }
}
