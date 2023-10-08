package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.response.DesafioResponse;
import br.ifsul.writerscircle.domain.Desafio;
import br.ifsul.writerscircle.mapper.DesafioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.ifsul.writerscircle.mapper.DesafioMapper.toResponse;

@Service
public class DetalharDesafioService {
    @Autowired
    private BuscarDesafioService buscarDesafioService;

    public DesafioResponse detalhar(Long idDesafio){
        Desafio desafio = buscarDesafioService.porId(idDesafio);

        return toResponse(desafio);
    }
}
