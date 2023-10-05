package br.ifsul.writerscircle.security.mapper;

import br.ifsul.writerscircle.security.controller.response.UsuarioAmizadeResponse;
import br.ifsul.writerscircle.security.controller.response.UsuarioResumidoResponse;
import br.ifsul.writerscircle.security.domain.Usuario;

public class UsuarioAmizadeMapper {
    public static UsuarioAmizadeResponse toResponse(Usuario entity){
        return UsuarioAmizadeResponse.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .imagem(entity.getImagemPerfil())
                .bio(entity.getBio())
                .build();
    }
}
