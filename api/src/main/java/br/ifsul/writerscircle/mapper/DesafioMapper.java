package br.ifsul.writerscircle.mapper;

import br.ifsul.writerscircle.controller.request.GeneroRequest;
import br.ifsul.writerscircle.controller.response.DesafioResponse;
import br.ifsul.writerscircle.controller.response.GeneroResponse;
import br.ifsul.writerscircle.domain.Desafio;
import br.ifsul.writerscircle.domain.Genero;

public class DesafioMapper {
    public static DesafioResponse toResponse(Desafio entity){
        return DesafioResponse.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .descricao(entity.getDescricao())
                .autor(entity.getUsuario().getUsername())
                .comunidade(entity.isComunidade())
                .dataPublicacao(entity.getDataPublicacao())
                .dataFinal(entity.getDataFinal())
                .imagem(entity.getImagem())
                .build();
    }
}
