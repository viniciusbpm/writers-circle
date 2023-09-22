package br.ifsul.writerscircle.controller.request;

import br.ifsul.writerscircle.domain.Pagina;
import br.ifsul.writerscircle.security.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
public class ObraRequest {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotNull
    private List<GeneroRequest> generos;
}
