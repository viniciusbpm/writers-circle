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
public class SolicitacaoAmizade {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "remetente", nullable = false)
    private Usuario remetente;
    @ManyToOne
    @JoinColumn(name = "destinatario", nullable = false)
    private Usuario destinatario;


}
