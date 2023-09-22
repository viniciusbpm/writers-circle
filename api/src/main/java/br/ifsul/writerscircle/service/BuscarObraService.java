package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Obra;
import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.repository.ObraRepository;
import br.ifsul.writerscircle.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarObraService {
    @Autowired
    private ObraRepository obraRepository;
    private static final String MENSAGEM_OBRA_NAO_EXISTE = "Obra não encontrada";
    public Obra porId(Long id){
        Optional<Obra> obra = obraRepository.findById(id);

        if(obra.isEmpty()){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_OBRA_NAO_EXISTE);
        }

        return obra.get();
    }
}
