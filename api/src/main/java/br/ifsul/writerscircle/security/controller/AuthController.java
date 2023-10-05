package br.ifsul.writerscircle.security.controller;

import br.ifsul.writerscircle.security.controller.request.LoginRequest;
import br.ifsul.writerscircle.security.controller.request.UsuarioRequest;
import br.ifsul.writerscircle.security.controller.response.UsuarioResponse;
import br.ifsul.writerscircle.security.service.LoginService;
import br.ifsul.writerscircle.security.service.RegistrarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private RegistrarUsuarioService registrarUsuarioService;

    @PostMapping("/login")
    public UsuarioResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }

    @PostMapping("/register")
    public void registrar(@RequestBody @Valid UsuarioRequest request) {
        registrarUsuarioService.registrar(request);
    }

}
