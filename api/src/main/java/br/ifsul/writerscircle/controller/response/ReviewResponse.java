package br.ifsul.writerscircle.controller.response;

import br.ifsul.writerscircle.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewResponse {
    private Long id;
    private String titulo;
    private String conteudo;
    private LocalDateTime dataPublicacao;
    private LocalDateTime imagem;
}
