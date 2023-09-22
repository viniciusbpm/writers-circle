package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.response.ObraResponse;
import br.ifsul.writerscircle.service.ListarObrasUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("obras")
public class ObraController {
    @Autowired
    private ListarObrasUsuarioService listarObrasUsuarioService;
    @GetMapping("{idUsuario}")
    public List<ObraResponse> listarDoUsuario(@PathVariable Long idUsuario){
        return listarObrasUsuarioService.listar(idUsuario);
    }
}
