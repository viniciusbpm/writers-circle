package br.ifsul.writerscircle.mapper;

import br.ifsul.writerscircle.controller.request.GeneroRequest;
import br.ifsul.writerscircle.controller.response.AmizadeResponse;
import br.ifsul.writerscircle.controller.response.GeneroResponse;
import br.ifsul.writerscircle.domain.Amizade;
import br.ifsul.writerscircle.domain.Genero;
import br.ifsul.writerscircle.security.mapper.UsuarioAmizadeMapper;
import br.ifsul.writerscircle.security.mapper.UsuarioResumidoMapper;

public class AmizadeMapper {
    public static AmizadeResponse toResponse(Amizade entity){
        return AmizadeResponse.builder()
                .id(entity.getId())
                .primeiroUsuario(UsuarioAmizadeMapper.toResponse(entity.getPrimeiroUsuario()))
                .segundoUsuario(UsuarioAmizadeMapper.toResponse(entity.getSegundoUsuario()))
                .build();
    }
}
