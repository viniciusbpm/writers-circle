package br.ifsul.writerscircle.security.service;


import br.ifsul.writerscircle.security.domain.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String generateToken(Usuario user) {
        String secret = System.getenv("JWT_SECRET");
        return JWT.create()
                .withIssuer("Livros")
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(60)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256(secret));
    }

    public String getSubject(String token){
        String secret = System.getenv("JWT_SECRET");
        return JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("Livros")
                .build().verify(token).getSubject();
    }

}
