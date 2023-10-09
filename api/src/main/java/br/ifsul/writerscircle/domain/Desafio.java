package br.ifsul.writerscircle.domain;

import br.ifsul.writerscircle.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Desafio {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "imagem", nullable = false)
    private String imagem;
    @Column(name = "data_publicacao", nullable = false)
    private LocalDateTime dataPublicacao;
    @Column(name = "data_final")
    private LocalDateTime dataFinal;
    @Column(name = "comunidade", nullable = false)
    private boolean comunidade;
    @Column(name = "aprovado", nullable = false)
    private boolean aprovado;
    @OneToMany(mappedBy = "desafio")
    private List<RespostaDesafio> respostas = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public void adicionarResposta(RespostaDesafio respostaDesafio){
        this.respostas.add(respostaDesafio);
    }

    public void removerResposta(RespostaDesafio respostaDesafio){
        this.respostas.remove(respostaDesafio);
        respostaDesafio.setDesafio(null);
    }
}
