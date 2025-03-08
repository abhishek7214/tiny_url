package com.tiny_url.controller;

import com.tiny_url.dto.UrlDto;
import com.tiny_url.service.AuthService;
import com.tiny_url.service.GenerateTinyUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    @Autowired
    private GenerateTinyUrlService generateTinyUrlService;

    @Autowired
    private AuthService authService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody UrlDto urlDto,
        @RequestHeader("Authorization") String token) {
        try{
            authService.validateToken(token);
            String tinyUrl = generateTinyUrlService.generateTinyUrl(urlDto);
            return ResponseEntity.ok(tinyUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    }

    @GetMapping("/{tinyUrl}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable String tinyUrl
            , @RequestHeader("Authorization") String token) {
        try{
            authService.validateToken(token);
            return  ResponseEntity.ok(generateTinyUrlService.getOriginalUrl(tinyUrl));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

    }
}
