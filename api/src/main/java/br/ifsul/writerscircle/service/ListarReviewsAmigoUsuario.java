package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.response.ReviewResponse;
import br.ifsul.writerscircle.domain.Amizade;
import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.mapper.ReviewMapper;
import br.ifsul.writerscircle.repository.AmizadeRepository;
import br.ifsul.writerscircle.repository.ReviewRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.BuscarUsuarioService;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ListarReviewsAmigoUsuario {
    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private AmizadeRepository amizadeRepository;
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;

    public Page<ReviewResponse> listar(Pageable pageable){
        Usuario usuario = getUsuarioAutenticadoService.get();

        List<Amizade> amigos = amizadeRepository.findAllByPrimeiroUsuarioOrSegundoUsuario(usuario, usuario);
        List<Usuario> usuariosAmigos = amigos.stream().map(amizade -> {
            if(!Objects.equals(amizade.getPrimeiroUsuario().getId(), usuario.getId())){
                return amizade.getPrimeiroUsuario();
            } else return amizade.getSegundoUsuario();
        }).toList();

        Page<Review> reviews = reviewRepository.findReviewsAmigos(usuariosAmigos, pageable);

        return reviews.map(ReviewMapper::toResponse);
    }
}
