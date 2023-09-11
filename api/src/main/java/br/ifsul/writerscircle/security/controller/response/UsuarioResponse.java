package br.ifsul.writerscircle.security.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioResponse {
    private Long id;
    private String username;
    private String email;
    private String dataNascimento;
    private String token;
}
