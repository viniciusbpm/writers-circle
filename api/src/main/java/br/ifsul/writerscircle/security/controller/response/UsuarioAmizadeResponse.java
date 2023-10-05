package br.ifsul.writerscircle.security.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioAmizadeResponse {
    private Long id;
    private String username;
    private String imagem;
    private String bio;
}
