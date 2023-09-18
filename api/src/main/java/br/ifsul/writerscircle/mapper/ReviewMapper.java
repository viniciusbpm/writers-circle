package br.ifsul.writerscircle.mapper;

import br.ifsul.writerscircle.controller.response.ReviewResponse;
import br.ifsul.writerscircle.domain.Review;

public class ReviewMapper {
    public static ReviewResponse toResponse(Review review){
        return ReviewResponse.builder()
                .id(review.getId())
                .titulo(review.getTitulo())
                .conteudo(review.getConteudo())
                .dataPublicacao(review.getDataPublicacao())
                .imagem(review.getImagem())
                .build();
    }
}
