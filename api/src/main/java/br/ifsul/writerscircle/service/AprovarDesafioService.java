package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Desafio;
import br.ifsul.writerscircle.repository.DesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AprovarDesafioService {
    @Autowired
    private BuscarDesafioService buscarDesafioService;
    @Autowired
    private DesafioRepository desafioRepository;

    public void aprovar(Long idDesafio){
        Desafio desafio = buscarDesafioService.porId(idDesafio);

        desafio.setAprovado(true);

        desafioRepository.save(desafio);
    }
}
