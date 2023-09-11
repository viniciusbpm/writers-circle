package br.ifsul.writerscircle.security.mapper;

import br.ifsul.writerscircle.security.controller.request.UsuarioRequest;
import br.ifsul.writerscircle.security.controller.response.UsuarioResponse;
import br.ifsul.writerscircle.security.domain.Usuario;

public class UsuarioMapper {
    public static UsuarioResponse toResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .build();
    }

    public static Usuario toEntity(UsuarioRequest request){
        return Usuario.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .dataNascimento(request.getDataNascimento())
                .ativo(true)
                .build();
    }
}
