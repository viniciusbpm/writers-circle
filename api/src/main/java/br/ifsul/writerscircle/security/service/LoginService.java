package br.ifsul.writerscircle.security.service;

import br.ifsul.writerscircle.security.controller.request.LoginRequest;
import br.ifsul.writerscircle.security.controller.response.UsuarioResponse;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    private static final String CREDENCIAIS_INVALIDAS = "Email ou senha inválida";

    public UsuarioResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

        try {
            Authentication authentication =
                    this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

            var user = (Usuario) authentication.getPrincipal();

            UsuarioResponse response = UsuarioMapper.toResponse(user);
            response.setToken(tokenService.generateToken(user));

            return response;
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST, CREDENCIAIS_INVALIDAS);
        }
    }
    }
