package br.ifsul.writerscircle.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GeneroResponse {
    private Long id;
    private String nome;
}
