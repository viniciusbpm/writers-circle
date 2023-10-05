package br.ifsul.writerscircle.controller.response;

import br.ifsul.writerscircle.security.controller.response.UsuarioResponse;
import br.ifsul.writerscircle.security.controller.response.UsuarioResumidoResponse;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SolicitacaoAmizadeResponse {
    private Long id;
    private UsuarioResumidoResponse remetente;
    private UsuarioResumidoResponse destinatario;
}
