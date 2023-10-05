package br.ifsul.writerscircle.security.controller.response;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioResumidoResponse {
    private Long id;
    private String username;
}
