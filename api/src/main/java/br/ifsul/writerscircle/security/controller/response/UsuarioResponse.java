package br.ifsul.writerscircle.security.controller.response;

import br.ifsul.writerscircle.controller.response.GeneroResponse;
import br.ifsul.writerscircle.domain.Genero;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioResponse {
    private Long id;
    private String username;
    private String email;
    private String bio;
    private LocalDate dataNascimento;
    private LocalDate dataCriacao;
    private String imagemPerfil;
    private String escritorFavorito;
    private String livroFavorito;
    private List<GeneroResponse> generos = new ArrayList<>();
}
