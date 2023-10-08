package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.response.DesafioResponse;
import br.ifsul.writerscircle.controller.response.RespostaDesafioResponse;
import br.ifsul.writerscircle.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("desafios")
public class DesafioController {
    @Autowired
    private ListarDesafiosAprovadosService listarDesafiosAprovadosService;
    @Autowired
    private ListarDesafiosPendentesService listarDesafiosPendentesService;
    @Autowired
    private DetalharDesafioService detalharDesafioService;
    @Autowired
    private AprovarDesafioService aprovarDesafioService;
    @Autowired
    private ListarRespostasDesafioService listarRespostasDesafioService;
    
    @GetMapping
    public List<DesafioResponse> listarAprovados(){
        return listarDesafiosAprovadosService.listar();
    }

    @GetMapping("pendentes")
    public List<DesafioResponse> listarPendentes(){
        return listarDesafiosPendentesService.listar();
    }

    @GetMapping("{idDesafio}")
    public DesafioResponse detalhar(@PathVariable Long idDesafio){
        return detalharDesafioService.detalhar(idDesafio);
    }

    @GetMapping("respostas/{idDesafio}")
    public List<RespostaDesafioResponse> listarRespostas(@PathVariable Long idDesafio){
        return listarRespostasDesafioService.listar(idDesafio);
    }

    @PutMapping("aprovar/{idDesafio}")
    public void aprovar(@PathVariable Long idDesafio){
        aprovarDesafioService.aprovar(idDesafio);
    }



}
