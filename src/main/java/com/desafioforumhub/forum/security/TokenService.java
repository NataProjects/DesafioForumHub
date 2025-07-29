package com.desafioforumhub.forum.security;

import com.desafioforumhub.forum.model.Usuario;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Instant agora = Instant.now();
        Instant expiracao = agora.plusSeconds(3600); // 1h

        return Jwts.builder()
                .setIssuer("API Fórum")
                .setSubject(usuario.getEmail())
                .setIssuedAt(Date.from(agora))
                .setExpiration(Date.from(expiracao))
                .signWith(getChave(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getChave() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String getSubject(String tokenJWT) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getChave())
                    .build()
                    .parseClaimsJws(tokenJWT)
                    .getBody()
                    .getSubject();
        } catch (JwtException e) {
            return null;
        }
    }
}
