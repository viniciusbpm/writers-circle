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
public class Review {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "obra_avaliada", nullable = false)
    private String obraAvaliada;
    @Column(name = "conteudo", nullable = false)
    private String conteudo;
    @Column(name = "nota", nullable = false)
    private double nota;
    @Column(name = "data_publicacao", nullable = false)
    private LocalDateTime dataPublicacao;
    @Column(name = "imagem", nullable = false)
    private String imagem;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;



}
