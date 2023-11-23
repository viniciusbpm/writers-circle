package br.ifsul.writerscircle.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FraseResponse {
    private Long id;
    private String frase;
    private String autor;
}
