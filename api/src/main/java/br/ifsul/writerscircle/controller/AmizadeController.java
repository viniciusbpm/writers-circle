package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.request.IdRequest;
import br.ifsul.writerscircle.controller.response.AmizadeResponse;
import br.ifsul.writerscircle.controller.response.SolicitacaoAmizadeResponse;
import br.ifsul.writerscircle.service.AceitarSolicitacaoAmizadeService;
import br.ifsul.writerscircle.service.EnviarSolicitacaoAmizadeService;
import br.ifsul.writerscircle.service.ListarAmizadesService;
import br.ifsul.writerscircle.service.ListarSolicitacoesAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("amizades")
public class AmizadeController {
    @Autowired
    private ListarAmizadesService listarAmizadesService;

    @GetMapping
    public List<AmizadeResponse> listar(){
        return listarAmizadesService.listar();
    }
}
