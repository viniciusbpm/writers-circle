package br.ifsul.writerscircle.security.service;

import br.ifsul.writerscircle.security.controller.request.UsuarioRequest;
import br.ifsul.writerscircle.security.controller.response.UsuarioResponse;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

import static br.ifsul.writerscircle.security.mapper.UsuarioMapper.toEntity;
import static br.ifsul.writerscircle.security.mapper.UsuarioMapper.toResponse;

@Service
public class RegistrarUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ValidarEmailUnicoService validarEmailUnicoService;
    @Autowired
    private ValidarUsernameUnicoService validarUsernameUnicoService;

    @Transactional
    public void registrar(@Valid UsuarioRequest request){
        validarEmailUnicoService.validar(request.getEmail());
        validarUsernameUnicoService.validar(request.getUsername());

        Usuario user = toEntity(request);
        user.setSenha(passwordEncoder.encode(request.getSenha()));

        usuarioRepository.save(user);
    }

}
