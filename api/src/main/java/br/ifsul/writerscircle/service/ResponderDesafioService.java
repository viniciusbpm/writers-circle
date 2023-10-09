package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.request.RespostaDesafioRequest;
import br.ifsul.writerscircle.domain.Desafio;
import br.ifsul.writerscircle.domain.RespostaDesafio;
import br.ifsul.writerscircle.mapper.RespostaDesafioMapper;
import br.ifsul.writerscircle.repository.RespostaDesafioRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.ifsul.writerscircle.mapper.RespostaDesafioMapper.toEntity;

@Service
public class ResponderDesafioService {
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;
    @Autowired
    private BuscarDesafioService buscarDesafioService;
    @Autowired
    private RespostaDesafioRepository respostaDesafioRepository;

    public void responder(Long idDesafio, RespostaDesafioRequest request){
        Desafio desafio = buscarDesafioService.porId(idDesafio);
        Usuario usuario = getUsuarioAutenticadoService.get();

        RespostaDesafio respostaDesafio = toEntity(request);
        respostaDesafio.setDesafio(desafio);
        respostaDesafio.setUsuario(usuario);

        respostaDesafioRepository.save(respostaDesafio);

        usuario.adicionarRespostaDesafio(respostaDesafio);
        desafio.adicionarResposta(respostaDesafio);
    }
}
