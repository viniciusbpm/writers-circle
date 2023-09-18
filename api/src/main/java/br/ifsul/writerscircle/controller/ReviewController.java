package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.response.ReviewResponse;
import br.ifsul.writerscircle.service.ListarReviewsUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reviews")
public class ReviewController {
    @Autowired
    private ListarReviewsUsuarioService listarReviewsUsuarioService;

    @GetMapping("{idUsuario}")
    public List<ReviewResponse> listarDoUsuario(@PathVariable Long idUsuario){
        return listarReviewsUsuarioService.listar(idUsuario);
    }
}
