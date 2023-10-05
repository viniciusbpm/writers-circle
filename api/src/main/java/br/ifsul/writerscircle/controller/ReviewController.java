package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.request.ReviewRequest;
import br.ifsul.writerscircle.controller.response.ReviewResponse;
import br.ifsul.writerscircle.service.AdicionarReviewService;
import br.ifsul.writerscircle.service.EditarReviewService;
import br.ifsul.writerscircle.service.ListarReviewsUsuarioService;
import br.ifsul.writerscircle.service.RemoverReviewService;
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
    @Autowired
    private EditarReviewService editarReviewService;
    @Autowired
    private RemoverReviewService removerReviewService;

    @GetMapping("{idUsuario}")
    public List<ReviewResponse> listarDoUsuario(@PathVariable Long idUsuario){
        return listarReviewsUsuarioService.listar(idUsuario);
    }
    @PostMapping
    public ReviewResponse adicionar(@RequestBody ReviewRequest request){
        return adicionarReviewService.adicionar(request);
    }

    @PutMapping("{idReview}")
    public ReviewResponse editar(@RequestBody ReviewRequest request, @PathVariable Long idReview){
        return editarReviewService.editar(request, idReview);
    }

    @DeleteMapping("{idReview}")
    public void remover(@PathVariable Long idReview){
        removerReviewService.remover(idReview);
    }
}
