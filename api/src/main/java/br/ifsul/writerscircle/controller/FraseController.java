package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.response.FraseResponse;
import br.ifsul.writerscircle.service.BuscarFraseAleatoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("frases")
public class FraseController {
    @Autowired
    private BuscarFraseAleatoria buscarFraseAleatoria;

    @GetMapping("aleatoria")
    public FraseResponse aleatoria() {
        return buscarFraseAleatoria.buscar();
    };
}
