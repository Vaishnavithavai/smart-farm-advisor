package com.example.KrishiMitra.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    private Key getSignInKey() {
        return Keys.hmacShaKeyFor(
                secret.getBytes());
    }

    public String generateToken(
            String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + jwtExpiration))
                .signWith(
                        getSignInKey(),
                        SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(
            String token) {

        return Jwts.parserBuilder()
                .setSigningKey(
                        getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(
            String token,
            UserDetails userDetails) {

        String username =
                extractUsername(token);

        return username.equals(
                userDetails.getUsername());
    }
}