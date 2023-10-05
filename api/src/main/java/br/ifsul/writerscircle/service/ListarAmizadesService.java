package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.response.AmizadeResponse;
import br.ifsul.writerscircle.domain.Amizade;
import br.ifsul.writerscircle.mapper.AmizadeMapper;
import br.ifsul.writerscircle.repository.AmizadeRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ListarAmizadesService {
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;
    @Autowired
    private AmizadeRepository amizadeRepository;

    public List<AmizadeResponse> listar(){
        Usuario usuario = getUsuarioAutenticadoService.get();
        List<Amizade> amizades = amizadeRepository.findAllByPrimeiroUsuarioOrSegundoUsuario(usuario, usuario);

        return amizades.stream().map(AmizadeMapper::toResponse).collect(toList());

    }
}
