package br.ifsul.writerscircle.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RespostaDesafioRequest {
    @NotBlank
    private String conteudo;
}
