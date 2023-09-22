package br.ifsul.writerscircle.controller.response;

import br.ifsul.writerscircle.domain.Pagina;
import br.ifsul.writerscircle.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ObraResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataPublicacao;
    private boolean finalizado;
    private int numeroPaginas;
}
