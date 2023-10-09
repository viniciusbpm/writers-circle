package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.response.RespostaDesafioResponse;
import br.ifsul.writerscircle.domain.Desafio;
import br.ifsul.writerscircle.mapper.RespostaDesafioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ListarRespostasDesafioService {
    @Autowired
    private BuscarDesafioService buscarDesafioService;

    public List<RespostaDesafioResponse> listar(Long idDesafio){
        Desafio desafio = buscarDesafioService.porId(idDesafio);

        return desafio.getRespostas().stream()
                .map(RespostaDesafioMapper::toResponse)
                .collect(toList());
    }
}
