package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.response.AmizadeResponse;
import br.ifsul.writerscircle.controller.response.DesafioResponse;
import br.ifsul.writerscircle.service.ListarAmizadesService;
import br.ifsul.writerscircle.service.ListarDesafiosService;
import br.ifsul.writerscircle.service.RemoverAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("desafios")
public class DesafioController {
    @Autowired
    private ListarDesafiosService listarDesafiosService;

    @GetMapping
    public List<DesafioResponse> listarAprovados(){
        return listarDesafiosService.listar();
    }
}
