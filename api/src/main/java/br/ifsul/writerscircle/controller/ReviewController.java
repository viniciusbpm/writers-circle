package br.ifsul.writerscircle.controller;

import br.ifsul.writerscircle.controller.request.ReviewRequest;
import br.ifsul.writerscircle.controller.response.ReviewResponse;
import br.ifsul.writerscircle.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reviews")
public class ReviewController {
    @Autowired
    private ListarReviewsUsuarioService listarReviewsUsuarioService;
    @Autowired
    private ListarReviewsAmigoUsuario listarReviewsAmigoUsuario;
    @Autowired
    private AdicionarReviewService adicionarReviewService;
    @Autowired
    private EditarReviewService editarReviewService;
    @Autowired
    private RemoverReviewService removerReviewService;
    @Autowired
    private DetalherReviewService detalherReviewService;

    @GetMapping("/usuarios/{idUsuario}")
    public List<ReviewResponse> listarDoUsuario(@PathVariable Long idUsuario){
        return listarReviewsUsuarioService.listar(idUsuario);
    }

    @GetMapping("amigos")
    public Page<ReviewResponse> listarDosAmigosDoUsuario(Pageable pageable){
        return listarReviewsAmigoUsuario.listar(pageable);
    }

    @GetMapping("{idReview}")
    public ReviewResponse detalhar(@PathVariable Long idReview){
        return detalherReviewService.detalhar(idReview);
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
