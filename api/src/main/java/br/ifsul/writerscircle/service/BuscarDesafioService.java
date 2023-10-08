package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Desafio;
import br.ifsul.writerscircle.domain.Obra;
import br.ifsul.writerscircle.repository.DesafioRepository;
import br.ifsul.writerscircle.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarDesafioService {
    @Autowired
    private DesafioRepository desafioRepository;
    private static final String MENSAGEM_DESAFIO_NAO_EXISTE = "Desafio não encontrado";
    public Desafio porId(Long id){
        Optional<Desafio> desafio = desafioRepository.findById(id);

        if(desafio.isEmpty()){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_DESAFIO_NAO_EXISTE);
        }

        return desafio.get();
    }
}
