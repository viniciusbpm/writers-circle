package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.response.DesafioResponse;
import br.ifsul.writerscircle.domain.Desafio;
import br.ifsul.writerscircle.mapper.DesafioMapper;
import br.ifsul.writerscircle.repository.DesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;

@Service
public class ListarDesafiosAprovadosService {
    @Autowired
    private DesafioRepository desafioRepository;

    public List<DesafioResponse> listar(){
        List<Desafio> desafios = desafioRepository.findAllByDataFinalAfterAndAprovadoTrue(now());

        return desafios.stream()
                .map(DesafioMapper::toResponse)
                .collect(toList());
    }
}
