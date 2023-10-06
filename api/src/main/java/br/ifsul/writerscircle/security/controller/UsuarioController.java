package br.ifsul.writerscircle.security.controller;

import br.ifsul.writerscircle.security.controller.request.DetalhesPerfilRequest;
import br.ifsul.writerscircle.security.controller.response.LoginResponse;
import br.ifsul.writerscircle.security.controller.response.UsuarioResponse;
import br.ifsul.writerscircle.security.service.AdicionarDetalhesPerfilService;
import br.ifsul.writerscircle.security.service.VisualizarDetalhesPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private AdicionarDetalhesPerfilService adicionarDetalhesPerfilService;

    @Autowired
    private VisualizarDetalhesPerfilService visualizarDetalhesPerfilService;

    @PutMapping("/detalhes")
    public UsuarioResponse adicionarDetalhes(@RequestBody @Valid DetalhesPerfilRequest request) {
        return adicionarDetalhesPerfilService.adicionar(request);
    }

    @GetMapping("/detalhes/{idUsuario}")
    public UsuarioResponse visualizarDetalhes(@PathVariable Long idUsuario){
        return visualizarDetalhesPerfilService.visualizar(idUsuario);
    }
}
