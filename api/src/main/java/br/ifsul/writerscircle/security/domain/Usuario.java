package br.ifsul.writerscircle.security.domain;

import br.ifsul.writerscircle.domain.Genero;
import br.ifsul.writerscircle.domain.Obra;
import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.domain.SolicitacaoAmizade;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "bio")
    private String bio;
    @Column(name = "senha", nullable = false)
    private String senha;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "imagem_perfil")
    private String imagemPerfil;
    @Column(name = "token_senha")
    private String tokenSenha;
    @Column(name = "ativo", nullable = false)
    private boolean ativo;
    @Column(name = "escritor_favorito")
    private String escritorFavorito;
    @Column(name = "livro_favorito")
    private String livroFavorito;

    @ManyToMany
    @JoinTable(name = "genero_usuario",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "genero_id"))
    private List<Genero> generos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Review> reviews = new ArrayList<>();
    @OneToMany(mappedBy = "usuario")
    private List<Obra> obras = new ArrayList<>();
    @OneToMany(mappedBy = "destinatario")
    private List<SolicitacaoAmizade> solicitacoes = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "amizade",
            joinColumns = @JoinColumn(name = "primeiro_usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "segundo_usuario_id"))
    private List<Usuario> amigos = new ArrayList<>();

    public void adicionarReview(Review review){
        this.reviews.add(review);
        review.setUsuario(this);
    }
    public void removerReview(Review review){
        this.reviews.remove(review);
        review.setUsuario(null);
    }
    public void adicionarObra(Obra obra){
        this.obras.add(obra);
        obra.setUsuario(this);
    }
    public void removerObra(Obra obra){
        this.obras.remove(obra);
        obra.setUsuario(null);
    }
    public void adicionarAmigo(Usuario usuario){
        this.amigos.add(usuario);
        usuario.amigos.add(this);
    }
    public void removerAmigo(Usuario usuario){
        this.amigos.remove(usuario);
        usuario.amigos.remove(this);
    }
    public void adicionarSolicitacao(SolicitacaoAmizade solicitacaoAmizade){
        this.solicitacoes.add(solicitacaoAmizade);
        solicitacaoAmizade.getRemetente().solicitacoes.add(solicitacaoAmizade);
    }
    public void removerSolicitacao(SolicitacaoAmizade solicitacaoAmizade){
        this.solicitacoes.remove(solicitacaoAmizade);
        solicitacaoAmizade.getRemetente().solicitacoes.remove(solicitacaoAmizade);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
