package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Amizade;
import br.ifsul.writerscircle.domain.Genero;
import br.ifsul.writerscircle.repository.AmizadeRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarAmizadeService {
    @Autowired
    private AmizadeRepository amizadeRepository;
    private static final String MENSAGEM_AMIZADE_NAO_EXISTE = "Amizade não encontrada";

    public Amizade porId(Long id){
        Optional<Amizade> amizade = amizadeRepository.findById(id);

        if(amizade.isEmpty()){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_AMIZADE_NAO_EXISTE);
        }

        return amizade.get();
    }

    public Amizade porUsuarios(Usuario primeiroUsuario, Usuario segundoUsuario){
        Optional<Amizade> amizade1 = amizadeRepository.findByPrimeiroUsuarioAndSegundoUsuario(primeiroUsuario,
                segundoUsuario);

        Optional<Amizade> amizade2 = amizadeRepository.findByPrimeiroUsuarioAndSegundoUsuario(segundoUsuario,
                primeiroUsuario);

        return amizade1.orElseGet(() -> amizade2.orElse(null));
    }
}
