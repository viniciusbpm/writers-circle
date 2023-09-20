package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.request.ReviewRequest;
import br.ifsul.writerscircle.controller.response.ReviewResponse;
import br.ifsul.writerscircle.service.AdicionarReviewService;
import br.ifsul.writerscircle.service.ListarReviewsUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reviews")
public class ReviewController {
    @Autowired
    private ListarReviewsUsuarioService listarReviewsUsuarioService;

    @Autowired
    private AdicionarReviewService adicionarReviewService;

    @GetMapping("{idUsuario}")
    public List<ReviewResponse> listarDoUsuario(@PathVariable Long idUsuario){
        return listarReviewsUsuarioService.listar(idUsuario);
    }

    @PostMapping()
    public ReviewResponse adicionar(@RequestBody ReviewRequest request){
        return adicionarReviewService.adicionar(request);
    }
}
