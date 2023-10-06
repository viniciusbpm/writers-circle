package br.ifsul.writerscircle.security.mapper;

import br.ifsul.writerscircle.mapper.GeneroMapper;
import br.ifsul.writerscircle.security.controller.request.UsuarioRequest;
import br.ifsul.writerscircle.security.controller.response.LoginResponse;
import br.ifsul.writerscircle.security.controller.response.UsuarioResponse;
import br.ifsul.writerscircle.security.domain.Usuario;

import java.time.LocalDate;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;
import static java.util.stream.Collectors.toList;

public class UsuarioMapper {
    public static Usuario toEntity(UsuarioRequest request){
        return Usuario.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .dataNascimento(request.getDataNascimento())
                .dataCriacao(now())
                .ativo(true)
                .build();
    }

    public static UsuarioResponse toResponse(Usuario entity){
        return UsuarioResponse.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .bio(entity.getBio())
                .email(entity.getEmail())
                .dataNascimento(entity.getDataNascimento())
                .dataCriacao(entity.getDataCriacao())
                .escritorFavorito(entity.getEscritorFavorito())
                .livroFavorito(entity.getLivroFavorito())
                .imagemPerfil(entity.getImagemPerfil())
                .generos(entity.getGeneros().stream()
                        .map(GeneroMapper::toResponse)
                        .collect(toList()))
                .build();
    }
}
