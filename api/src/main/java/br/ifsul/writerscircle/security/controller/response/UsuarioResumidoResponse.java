package br.ifsul.writerscircle.security.controller.response;

import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioResumidoResponse {
    private Long id;
    private String username;
    private String imagem;

}
