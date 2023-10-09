package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Desafio;
import br.ifsul.writerscircle.repository.DesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoverDesafioService {
    @Autowired
    private BuscarDesafioService buscarDesafioService;
    @Autowired
    private DesafioRepository desafioRepository;

    public void remover(Long idDesafio){
        Desafio desafio = buscarDesafioService.porId(idDesafio);

        desafioRepository.delete(desafio);
    }
}
