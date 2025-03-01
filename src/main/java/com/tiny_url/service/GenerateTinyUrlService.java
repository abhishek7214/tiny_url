package com.tiny_url.service;

import com.tiny_url.dto.UrlDto;

public interface GenerateTinyUrlService {

    public String generateTinyUrl(UrlDto urlDto);
}
