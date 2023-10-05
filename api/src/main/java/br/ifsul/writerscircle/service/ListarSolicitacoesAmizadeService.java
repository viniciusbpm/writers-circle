package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.response.SolicitacaoAmizadeResponse;
import br.ifsul.writerscircle.mapper.SolicitacaoAmizadeMapper;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ListarSolicitacoesAmizadeService {
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;

    public List<SolicitacaoAmizadeResponse> listar(){
        Usuario usuario = getUsuarioAutenticadoService.get();

        return usuario.getSolicitacoes().stream()
                .map(SolicitacaoAmizadeMapper::toResponse)
                .collect(toList());
    }
}
