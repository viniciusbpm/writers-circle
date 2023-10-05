package br.ifsul.writerscircle.security.controller;

import br.ifsul.writerscircle.security.controller.request.DetalhesPerfilRequest;
import br.ifsul.writerscircle.security.service.AdicionarDetalhesPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
