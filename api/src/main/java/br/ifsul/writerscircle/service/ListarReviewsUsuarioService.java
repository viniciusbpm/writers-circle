package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.response.ReviewResponse;
import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.mapper.ReviewMapper;
import br.ifsul.writerscircle.repository.ReviewRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.BuscarUsuarioService;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ListarReviewsUsuarioService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    public List<ReviewResponse> listar(Long idUsuario){
        Usuario usuario = buscarUsuarioService.buscar(idUsuario);

        List<Review> reviews = reviewRepository.findAllByUsuarioEquals(usuario);

        return reviews.stream()
                .map(ReviewMapper::toResponse)
                .collect(toList());
    }
}
