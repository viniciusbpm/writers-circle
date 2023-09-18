package br.ifsul.writerscircle.security.controller.request;

import br.ifsul.writerscircle.controller.request.GeneroRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DetalhesPerfilRequest {
    private String imagemPerfil;
    private String bio;
    @NotNull
    private List<GeneroRequest> generos = new ArrayList<>();
    private String escritorFavorito;
    private String livroFavorito;
}
