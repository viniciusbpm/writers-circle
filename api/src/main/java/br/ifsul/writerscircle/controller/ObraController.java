package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.request.ObraRequest;
import br.ifsul.writerscircle.controller.response.ObraResponse;
import br.ifsul.writerscircle.service.AdicionarObraService;
import br.ifsul.writerscircle.service.ListarObrasUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("obras")
public class ObraController {
    @Autowired
    private ListarObrasUsuarioService listarObrasUsuarioService;
    @Autowired
    private AdicionarObraService adicionarObraService;
    @GetMapping("{idUsuario}")
    public List<ObraResponse> listarDoUsuario(@PathVariable Long idUsuario){
        return listarObrasUsuarioService.listar(idUsuario);
    }
    @PostMapping
    public ObraResponse adicionar(@RequestBody ObraRequest request){
        return adicionarObraService.adicionar(request);
    }
}
