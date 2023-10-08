package br.ifsul.writerscircle.controller.request;

import br.ifsul.writerscircle.domain.RespostaDesafio;
import br.ifsul.writerscircle.security.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
public class DesafioRequest {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotBlank
    private String imagem;
}
