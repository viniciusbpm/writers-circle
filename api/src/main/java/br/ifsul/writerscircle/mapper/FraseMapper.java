package br.ifsul.writerscircle.mapper;

import br.ifsul.writerscircle.controller.request.DesafioRequest;
import br.ifsul.writerscircle.controller.response.DesafioResponse;
import br.ifsul.writerscircle.controller.response.FraseResponse;
import br.ifsul.writerscircle.domain.Desafio;
import br.ifsul.writerscircle.domain.Frase;

public class FraseMapper {
    public static FraseResponse toResponse(Frase entity){
        return FraseResponse.builder()
                .id(entity.getId())
                .frase(entity.getFrase())
                .autor(entity.getAutor())
                .build();
    }
}
