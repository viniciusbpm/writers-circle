package br.ifsul.writerscircle.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RespostaDesafioResponse {
    private Long id;
    private String conteudo;
    private String autor;
}
