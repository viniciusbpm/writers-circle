package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Genero;
import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.repository.GeneroRepository;
import br.ifsul.writerscircle.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarGeneroService {
    @Autowired
    private GeneroRepository generoRepository;
    private static final String MENSAGEM_GENERO_NAO_EXISTE = "Gênero não encontrado";
    public Genero porId(Long id){
        Optional<Genero> genero = generoRepository.findById(id);

        if(genero.isEmpty()){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_GENERO_NAO_EXISTE);
        }

        return genero.get();
    }
}
