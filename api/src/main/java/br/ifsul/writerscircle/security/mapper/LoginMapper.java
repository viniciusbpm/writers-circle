package br.ifsul.writerscircle.security.mapper;

import br.ifsul.writerscircle.security.controller.response.LoginResponse;
import br.ifsul.writerscircle.security.domain.Usuario;

public class LoginMapper {
    public static LoginResponse toResponse(Usuario usuario) {
        return LoginResponse.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .dataNascimento(usuario.getDataNascimento())
                .build();
    }
}
