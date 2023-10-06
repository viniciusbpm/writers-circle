package br.ifsul.writerscircle.security.controller.response;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponse {
    private Long id;
    private String username;
    private String email;
    private LocalDate dataNascimento;
    private String token;
}
