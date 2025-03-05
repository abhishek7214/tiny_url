package com.tiny_url.controller;

import com.tiny_url.dto.UrlDto;
import com.tiny_url.service.GenerateTinyUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    @Autowired
    private GenerateTinyUrlService generateTinyUrlService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody UrlDto urlDto) {
        String tinyUrl = generateTinyUrlService.generateTinyUrl(urlDto);
        return ResponseEntity.ok(tinyUrl);
    }

    @GetMapping("/{tinyUrl}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable String tinyUrl) {
        return  ResponseEntity.ok(generateTinyUrlService.getOriginalUrl(tinyUrl));
    }
}
