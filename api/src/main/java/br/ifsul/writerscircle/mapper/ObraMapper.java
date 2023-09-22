package br.ifsul.writerscircle.mapper;

import br.ifsul.writerscircle.controller.request.ObraRequest;
import br.ifsul.writerscircle.controller.response.ObraResponse;
import br.ifsul.writerscircle.domain.Obra;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;

public class ObraMapper {
    public static Obra toEntity(ObraRequest request){
        return Obra.builder()
                .titulo(request.getTitulo())
                .descricao(request.getDescricao())
                .dataPublicacao(now())
                .paginas(new ArrayList<>())
                .finalizado(false)
                .build();
    }

    public static ObraResponse toResponse(Obra entity){
        return ObraResponse.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .descricao(entity.getDescricao())
                .dataPublicacao(entity.getDataPublicacao())
                .dataAlteracao(entity.getDataAlteracao())
                .finalizado(entity.isFinalizado())
                .numeroPaginas(entity.getPaginas().size())
                .generos(entity.getGeneros().stream()
                        .map(GeneroMapper::toResponse)
                        .collect(toList()))
                .build();
    }
}
