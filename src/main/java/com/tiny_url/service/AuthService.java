package com.tiny_url.service;

public interface AuthService {
    public String authenticate(String username, String password);

    public String validateToken(String token);
}
