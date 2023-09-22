package br.ifsul.writerscircle.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewResponse {
    private Long id;
    private String titulo;
    private String obraAvaliada;
    private String conteudo;
    private double nota;
    private LocalDateTime dataPublicacao;
    private String imagem;
}
