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
public class Pagina {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "conteudo", nullable = false)
    private String conteudo;
    @ManyToOne
    @JoinColumn(name = "obra_id", nullable = false)
    private Obra obra;
}
