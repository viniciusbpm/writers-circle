package br.ifsul.writerscircle.controller.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SolicitacaoAmizadeRequest {
    @NotNull
    private Long idDestinatario;
}
