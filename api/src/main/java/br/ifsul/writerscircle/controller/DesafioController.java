package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.request.DesafioRequest;
import br.ifsul.writerscircle.controller.request.RespostaDesafioRequest;
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
    @Autowired
    private ResponderDesafioService responderDesafioService;
    @Autowired
    private SugerirDesafioService sugerirDesafioService;
    @Autowired
    private AdicionarDesafioService adicionarDesafioService;
    @Autowired
    private RemoverDesafioService removerDesafioService;

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

    @GetMapping("{idDesafio}/respostas")
    public List<RespostaDesafioResponse> listarRespostas(@PathVariable Long idDesafio){
        return listarRespostasDesafioService.listar(idDesafio);
    }

    @PutMapping("{idDesafio}/aprovar")
    public void aprovar(@PathVariable Long idDesafio){
        aprovarDesafioService.aprovar(idDesafio);
    }

    @PostMapping("{idDesafio}/responder")
    public void responder(@PathVariable Long idDesafio, @RequestBody RespostaDesafioRequest request){
        responderDesafioService.responder(idDesafio, request);
    }

    @PostMapping
    public DesafioResponse adicionar(@RequestBody DesafioRequest request){
        return adicionarDesafioService.adicionar(request);
    }

    @PostMapping("sugerir")
    public DesafioResponse sugerir(@RequestBody DesafioRequest request){
        return sugerirDesafioService.sugerir(request);
    }

    @DeleteMapping("{idDesafio}")
    public void remover(@PathVariable Long idDesafio){
        removerDesafioService.remover(idDesafio);
    }

}
