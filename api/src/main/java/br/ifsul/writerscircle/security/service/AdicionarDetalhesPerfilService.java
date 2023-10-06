package br.ifsul.writerscircle.security.service;

import br.ifsul.writerscircle.domain.Genero;
import br.ifsul.writerscircle.mapper.GeneroMapper;
import br.ifsul.writerscircle.security.controller.request.DetalhesPerfilRequest;
import br.ifsul.writerscircle.security.controller.response.UsuarioResponse;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.mapper.UsuarioMapper;
import br.ifsul.writerscircle.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.ifsul.writerscircle.security.mapper.UsuarioMapper.toResponse;

@Service
public class AdicionarDetalhesPerfilService {
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponse adicionar(DetalhesPerfilRequest request){
        Usuario usuario = getUsuarioAutenticadoService.get();
        List<Genero> generos = request.getGeneros().stream()
                .map(GeneroMapper::toEntity)
                .toList();

        usuario.setImagemPerfil(request.getImagemPerfil());
        usuario.setBio(request.getBio());
        usuario.setEscritorFavorito(request.getEscritorFavorito());
        usuario.setLivroFavorito(request.getLivroFavorito());
        usuario.getGeneros()
                .addAll(generos);

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }
}
