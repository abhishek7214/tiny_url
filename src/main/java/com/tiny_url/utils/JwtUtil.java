package com.tiny_url.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Secret Key (for simplicity, hardcoded here; ideally, use a secure environment variable)
    private static final String SECRET_KEY = "your-secure-random-secret-key-for-jwt-signing";

    // Token expiration time (e.g., 1 hour)
    private static final long EXPIRATION_TIME = 3600000;

    // Generate JWT token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)                        // Subject (username)
                .setIssuedAt(new Date())                     // Issued time
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Expiration time
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // Signing with secret key
                .compact();
    }

    // Extract username from token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Signing key creation
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
}