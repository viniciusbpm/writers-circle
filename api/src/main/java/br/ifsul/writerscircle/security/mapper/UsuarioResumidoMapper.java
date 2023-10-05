package br.ifsul.writerscircle.security.mapper;

import br.ifsul.writerscircle.security.controller.response.UsuarioResumidoResponse;
import br.ifsul.writerscircle.security.domain.Usuario;

public class UsuarioResumidoMapper {
    public static UsuarioResumidoResponse toResponse(Usuario entity){
        return UsuarioResumidoResponse.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .build();
    }
}
