package br.ifsul.writerscircle.security.controller;

import br.ifsul.writerscircle.security.controller.request.DetalhesPerfilRequest;
import br.ifsul.writerscircle.security.controller.request.UsuarioRequest;
import br.ifsul.writerscircle.security.controller.response.UsuarioResponse;
import br.ifsul.writerscircle.security.service.AdicionarDetalhesPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private AdicionarDetalhesPerfilService adicionarDetalhesPerfilService;

    @PutMapping("/detalhes")
    public void adicionarDetalhes(@RequestBody @Valid DetalhesPerfilRequest request) {
        adicionarDetalhesPerfilService.adicionar(request);
    }
}
