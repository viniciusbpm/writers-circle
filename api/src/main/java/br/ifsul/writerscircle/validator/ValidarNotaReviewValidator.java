package br.ifsul.writerscircle.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class ValidarNotaReviewValidator {
    public static final String MENSAGEM_NOTA_INVALIDA = "Reviews só podem conter notas de 1 a 5";
    public void validar(double nota){
        if(nota > 5 || nota < 0){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_NOTA_INVALIDA);
        }
    }
}
