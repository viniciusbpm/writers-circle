package br.ifsul.writerscircle.controller.response;

import br.ifsul.writerscircle.security.controller.response.UsuarioResumidoResponse;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AmizadeResponse {
    private Long id;
    private UsuarioResumidoResponse primeiroUsuario;
    private UsuarioResumidoResponse segundoUsuario;
}
