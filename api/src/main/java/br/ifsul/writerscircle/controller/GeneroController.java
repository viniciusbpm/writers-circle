package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.response.GeneroResponse;
import br.ifsul.writerscircle.service.BuscarGeneroPorNomeService;
import br.ifsul.writerscircle.service.ListarGenerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroController {
    @Autowired
    private ListarGenerosService listarGenerosService;
    @Autowired
    private BuscarGeneroPorNomeService buscarGeneroPorNomeService;

    @GetMapping
    public List<GeneroResponse> listar(){
        return listarGenerosService.listar();
    }

    @GetMapping("buscar")
    public List<GeneroResponse> buscar(@RequestParam String nome){
        return buscarGeneroPorNomeService.buscar(nome);
    }
}
