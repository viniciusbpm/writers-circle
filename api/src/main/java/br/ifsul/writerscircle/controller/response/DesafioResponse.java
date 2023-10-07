package br.ifsul.writerscircle.controller.response;

import br.ifsul.writerscircle.domain.RespostaDesafio;
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
public class DesafioResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private String autor;
    private String imagem;
    private LocalDateTime dataPublicacao;
    private LocalDateTime dataFinal;
    private boolean comunidade;
}
