package com.ms.rest.base.service.auth;

import com.ms.rest.base.domain.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class TokenService {
    private static final String SECRET_STRING = "VZ3mFa4IeHw5Z3GtAZKauyT4L2bqLp0f3nY7BgcWFZo=";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_STRING));

    private static final long EXPIRATION_TIME = 1000 * 60 * 30; // 30 Minutes

    private SecretKey getSigningKey() {
        return SECRET_KEY;
    }

    public String generateToken(Account account) {
        Map<String, String> claims = new HashMap<>();
        claims.put("id", String.valueOf(account.getId()));
        claims.put("username", account.getUsername());
        claims.put("email", account.getEmail());
        claims.put("fullName", account.getFullName());

        return Jwts.builder()
                .claims(claims)
                .subject(String.valueOf(account.getId()))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey())
                .compact();
    }

    public Long extractAccountId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return Long.valueOf(claims.getSubject());
    }

    public boolean validateToken(String token, String username) {
        return (extractAccountId(token).equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }

}
