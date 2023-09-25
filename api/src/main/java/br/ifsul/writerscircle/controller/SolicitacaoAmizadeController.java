package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.response.SolicitacaoAmizadeResponse;
import br.ifsul.writerscircle.service.ListarSolicitacoesAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("solicitacoes")
public class SolicitacaoAmizadeController {
    @Autowired
    private ListarSolicitacoesAmizadeService listarSolicitacoesAmizadeService;

    @GetMapping
    public List<SolicitacaoAmizadeResponse> listar(){
        return listarSolicitacoesAmizadeService.listar();
    }
}
