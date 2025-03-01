package com.tiny_url.controller;

import com.tiny_url.dto.UrlDto;
import com.tiny_url.service.GenerateTinyUrlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Tiny URL API", description = "API for shortening URLs")
public class UrlController {

    @Autowired
    private GenerateTinyUrlService generateTinyUrlService;

    @PostMapping("/short-url")
    @Operation(summary = "Shorten a URL", description = "Converts a long URL into a short URL.")
    public String shortUrl(@RequestBody UrlDto urlDto){
        return generateTinyUrlService.generateTinyUrl(urlDto);
    }
}
