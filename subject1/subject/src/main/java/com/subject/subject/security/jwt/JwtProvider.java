package com.subject.subject.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {

    private final Key key;

    public JwtProvider(@Value("@jwt.secret") String secret) {
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public Date getExpireDate() {
        return new Date(new Date().getTime() + (1000l * 60 * 60 * 24 * 30));
    }

    public String generateAccessToken(String username) {
        return Jwts.builder()
                .claim("username", username)
                .expiration(getExpireDate())
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String removeBearer(String bearerToken) throws RuntimeException {
        if (bearerToken == null) {
            throw new RuntimeException();
        }
        int bearerLength = "bearer ".length();
        return bearerToken.substring(bearerLength);

    }

    public String getClaims(String token) {
        JwtProvider jwtProvider = Jwts.parser()
                .setSigningKey(key)
                .build();

        return jwtProvider.parseClaimsJws(token).getPayload();
    }
}
