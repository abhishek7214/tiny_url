package com.tiny_url.controller;

import com.tiny_url.dto.UrlDto;
import com.tiny_url.service.GenerateTinyUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    @Autowired
    private GenerateTinyUrlService generateTinyUrlService;

    @PostMapping("/shorten")
    public ResponseEntity<UrlDto> shortenUrl(@RequestBody UrlDto urlDto) {
        String tinyUrl = generateTinyUrlService.generateTinyUrl(urlDto);
        return ResponseEntity.ok(urlDto);
    }
}
