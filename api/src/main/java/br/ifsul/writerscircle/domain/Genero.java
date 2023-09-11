package br.ifsul.writerscircle.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Genero {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
}
