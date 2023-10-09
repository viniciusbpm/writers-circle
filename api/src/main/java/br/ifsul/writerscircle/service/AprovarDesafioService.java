package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Desafio;
import br.ifsul.writerscircle.repository.DesafioRepository;
import br.ifsul.writerscircle.validator.ValidarDesafioNaoEstaAprovadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Service
public class AprovarDesafioService {
    @Autowired
    private BuscarDesafioService buscarDesafioService;
    @Autowired
    private DesafioRepository desafioRepository;
    @Autowired
    private ValidarDesafioNaoEstaAprovadoValidator validarDesafioNaoEstaAprovadoValidator;
    public static final int DURACAO_DIAS_DESAFIO = 7;

    public void aprovar(Long idDesafio){
        Desafio desafio = buscarDesafioService.porId(idDesafio);

        validarDesafioNaoEstaAprovadoValidator.validar(desafio);

        desafio.setAprovado(true);
        desafio.setDataFinal(now().plusDays(DURACAO_DIAS_DESAFIO));

        desafioRepository.save(desafio);
    }
}
