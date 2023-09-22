package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.request.ObraRequest;
import br.ifsul.writerscircle.controller.response.ObraResponse;
import br.ifsul.writerscircle.service.AdicionarObraService;
import br.ifsul.writerscircle.service.EditarObraService;
import br.ifsul.writerscircle.service.ListarObrasUsuarioService;
import br.ifsul.writerscircle.service.RemoverObraService;
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
    @Autowired
    private EditarObraService editarObraService;
    @Autowired
    private RemoverObraService removerObraService;
    @GetMapping("{idUsuario}")
    public List<ObraResponse> listarDoUsuario(@PathVariable Long idUsuario){
        return listarObrasUsuarioService.listar(idUsuario);
    }
    @PostMapping
    public ObraResponse adicionar(@RequestBody ObraRequest request){
        return adicionarObraService.adicionar(request);
    }
    @PutMapping("{idObra}")
    public ObraResponse editar(@RequestBody ObraRequest request, @PathVariable Long idObra){
        return editarObraService.editar(request, idObra);
    }
    @DeleteMapping("{idObra}")
    public void remover(@PathVariable Long idObra){
        removerObraService.remover(idObra);
    }

}
