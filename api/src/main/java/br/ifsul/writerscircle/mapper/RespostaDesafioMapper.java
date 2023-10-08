package br.ifsul.writerscircle.mapper;

import br.ifsul.writerscircle.controller.response.DesafioResponse;
import br.ifsul.writerscircle.controller.response.RespostaDesafioResponse;
import br.ifsul.writerscircle.domain.Desafio;
import br.ifsul.writerscircle.domain.RespostaDesafio;

public class RespostaDesafioMapper {
    public static RespostaDesafioResponse toResponse(RespostaDesafio entity){
        return RespostaDesafioResponse.builder()
                .id(entity.getId())
                .conteudo(entity.getConteudo())
                .autor(entity.getUsuario().getUsername())
                .build();
    }
}
