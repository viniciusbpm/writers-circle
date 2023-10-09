package br.ifsul.writerscircle.domain;

import br.ifsul.writerscircle.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class RespostaDesafio {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "conteudo", nullable = false)
    private String conteudo;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "desafio_id", nullable = false)
    private Desafio desafio;
}
