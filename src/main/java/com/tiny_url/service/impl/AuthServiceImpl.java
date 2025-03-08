package com.tiny_url.service.impl;

import com.tiny_url.service.AuthService;
import com.tiny_url.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String authenticate(String username, String password) {
        // Ideally, validate the username and password from the database
        if ("admin".equals(username) && "password123".equals(password)) {
            return jwtUtil.generateToken(username);
        }
        throw new RuntimeException("Invalid credentials");
    }

    @Override
    public String validateToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return jwtUtil.extractUsername(authorizationHeader.substring(7));
        }
        throw new RuntimeException("Invalid token");
    }
}
