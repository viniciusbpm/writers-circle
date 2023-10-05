package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.response.ObraResponse;
import br.ifsul.writerscircle.mapper.ObraMapper;
import br.ifsul.writerscircle.repository.ObraRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ListarObrasUsuarioService {
    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    public List<ObraResponse> listar(Long idUsuario){
        Usuario usuario = buscarUsuarioService.porId(idUsuario);
        return usuario.getObras().stream()
                .map(ObraMapper::toResponse)
                .collect(toList());
    }
}
