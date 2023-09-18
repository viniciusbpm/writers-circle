package br.ifsul.writerscircle.mapper;

import br.ifsul.writerscircle.controller.request.GeneroRequest;
import br.ifsul.writerscircle.controller.response.GeneroResponse;
import br.ifsul.writerscircle.domain.Genero;

public class GeneroMapper {
    public static Genero toEntity(GeneroRequest request){
        return Genero.builder()
                .id(request.getId())
                .nome(request.getNome())
                .build();
    }

    public static GeneroResponse toResponse(Genero entity){
        return GeneroResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .build();
    }
}
