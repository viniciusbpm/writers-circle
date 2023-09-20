package br.ifsul.writerscircle.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReviewRequest {
    @NotBlank
    private String titulo;
    @NotBlank
    private String obraAvaliada;
    @NotBlank
    private String conteudo;
    @NotNull
    private double nota;
    @NotBlank
    private String imagem;
}
