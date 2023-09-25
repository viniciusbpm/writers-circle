package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.request.SolicitacaoAmizadeRequest;
import br.ifsul.writerscircle.controller.response.SolicitacaoAmizadeResponse;
import br.ifsul.writerscircle.service.EnviarSolicitacaoAmizadeService;
import br.ifsul.writerscircle.service.ListarSolicitacoesAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("solicitacoes")
public class SolicitacaoAmizadeController {
    @Autowired
    private ListarSolicitacoesAmizadeService listarSolicitacoesAmizadeService;

    @Autowired
    private EnviarSolicitacaoAmizadeService enviarSolicitacaoAmizadeService;

    @GetMapping
    public List<SolicitacaoAmizadeResponse> listar(){
        return listarSolicitacoesAmizadeService.listar();
    }

    @PostMapping
    public SolicitacaoAmizadeResponse enviar(@RequestBody SolicitacaoAmizadeRequest request){
        return enviarSolicitacaoAmizadeService.enviar(request);
    }
}
