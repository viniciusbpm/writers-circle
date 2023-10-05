package br.ifsul.writerscircle.domain;

import br.ifsul.writerscircle.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Amizade {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "primeiro_usuario_id", nullable = false)
    private Usuario primeiroUsuario;
    @ManyToOne
    @JoinColumn(name = "segundo_usuario_id", nullable = false)
    private Usuario segundoUsuario;


}
