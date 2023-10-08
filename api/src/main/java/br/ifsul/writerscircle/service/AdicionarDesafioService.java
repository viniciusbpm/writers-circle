package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.request.DesafioRequest;
import br.ifsul.writerscircle.controller.response.DesafioResponse;
import br.ifsul.writerscircle.domain.Desafio;
import br.ifsul.writerscircle.mapper.DesafioMapper;
import br.ifsul.writerscircle.repository.DesafioRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static br.ifsul.writerscircle.mapper.DesafioMapper.toEntity;
import static br.ifsul.writerscircle.mapper.DesafioMapper.toResponse;
import static java.time.LocalDateTime.now;

@Service
public class AdicionarDesafioService {
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;
    @Autowired
    private DesafioRepository desafioRepository;
    public static final int DIAS_DESAFIO_DISPONIVEL = 7;

    public DesafioResponse adicionar(DesafioRequest request){
        Usuario usuario = getUsuarioAutenticadoService.get();
        Desafio desafio = toEntity(request);

        desafio.setUsuario(usuario);
        desafio.setDataPublicacao(now());
        desafio.setDataFinal(now().plusDays(DIAS_DESAFIO_DISPONIVEL));
        desafio.setComunidade(false);
        desafio.setAprovado(true);

        desafioRepository.save(desafio);

        return toResponse(desafio);
    }
}
