package br.ifsul.writerscircle.mapper;

import br.ifsul.writerscircle.controller.response.ObraResponse;
import br.ifsul.writerscircle.domain.Obra;

public class ObraMapper {
    public static ObraResponse toResponse(Obra entity){
        return ObraResponse.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .descricao(entity.getDescricao())
                .dataPublicacao(entity.getDataPublicacao())
                .finalizado(entity.isFinalizado())
                .numeroPaginas(entity.getPaginas().size())
                .build();
    }
}
