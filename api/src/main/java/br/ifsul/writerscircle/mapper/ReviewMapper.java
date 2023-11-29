package br.ifsul.writerscircle.mapper;

import br.ifsul.writerscircle.controller.request.ReviewRequest;
import br.ifsul.writerscircle.controller.response.ReviewResponse;
import br.ifsul.writerscircle.domain.Review;

public class ReviewMapper {
    public static Review toEntity(ReviewRequest request){
        return Review.builder()
                .titulo(request.getTitulo())
                .obraAvaliada(request.getObraAvaliada())
                .conteudo(request.getConteudo())
                .imagem(request.getImagem())
                .nota(request.getNota())
                .build();
    }
    public static ReviewResponse toResponse(Review review){
        return ReviewResponse.builder()
                .id(review.getId())
                .titulo(review.getTitulo())
                .autor(review.getUsuario().getUsername())
                .conteudo(review.getConteudo())
                .nota(review.getNota())
                .obraAvaliada(review.getObraAvaliada())
                .dataPublicacao(review.getDataPublicacao())
                .imagem(review.getImagem())
                .build();
    }
}
