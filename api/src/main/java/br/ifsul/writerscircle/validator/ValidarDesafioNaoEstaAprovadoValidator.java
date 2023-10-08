package br.ifsul.writerscircle.validator;

import br.ifsul.writerscircle.domain.Desafio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class ValidarDesafioNaoEstaAprovadoValidator {
    public static final String MENSAGEM_DESAFIO_JA_APROVADO = "Este desafio já foi aprovado";
    public void validar(Desafio desafio){
        if(desafio.isAprovado()){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_DESAFIO_JA_APROVADO);
        }
    }
}
