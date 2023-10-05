package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.request.IdRequest;
import br.ifsul.writerscircle.controller.response.AmizadeResponse;
import br.ifsul.writerscircle.controller.response.SolicitacaoAmizadeResponse;
import br.ifsul.writerscircle.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("amizades")
public class AmizadeController {
    @Autowired
    private ListarAmizadesService listarAmizadesService;

    @Autowired
    private RemoverAmizadeService removerAmizadeService;

    @GetMapping
    public List<AmizadeResponse> listar(){
        return listarAmizadesService.listar();
    }

    @DeleteMapping("{idAmizade}")
    public void remover(@PathVariable Long idAmizade){
        removerAmizadeService.remover(idAmizade);
    }
}
