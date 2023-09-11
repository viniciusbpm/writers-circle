package br.ifsul.writerscircle.security.service;

import br.ifsul.writerscircle.security.controller.request.DetalhesPerfilRequest;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.ifsul.writerscircle.mapper.GeneroMapper.toEntity;

@Service
public class AdicionarDetalhesPerfilService {
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void adicionar(DetalhesPerfilRequest request){
        Usuario usuario = getUsuarioAutenticadoService.get();

        usuario.setImagemPerfil(request.getImagemPerfil());
        usuario.setBio(request.getBio());
        usuario.setEscritorFavorito(request.getEscritorFavorito());
        usuario.setLivroFavorito(request.getLivroFavorito());

        request.getGeneros()
                .forEach(genero -> usuario.getGeneros().add(toEntity(genero)));

        usuarioRepository.save(usuario);
    }
}
