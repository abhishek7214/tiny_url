package com.tiny_url.service.impl;

import com.tiny_url.dto.UrlDto;
import com.tiny_url.entity.UrlEntity;
import com.tiny_url.repository.UrlRepository;
import com.tiny_url.service.GenerateTinyUrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class GenerateTinyUrlServiceImpl implements GenerateTinyUrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public String generateTinyUrl(UrlDto urlDto) {
        log.info("generateTinyUrl");
        String tinyUrl = generateHashString(urlDto);
        UrlEntity existUrl = urlRepository.findByTinyUrl(tinyUrl);
        if(existUrl != null){
            return tinyUrl;
        }
        log.info("tinyUrl: {}", tinyUrl);
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setOriginalUrl(urlDto.getUrl());
        urlEntity.setTinyUrl(tinyUrl);
        urlEntity.setExpired(false);
        urlEntity.setExpireAt(getExpireAt(urlDto));
        urlRepository.save(urlEntity);
        return tinyUrl;
    }

    @Override
    public String getOriginalUrl(String tinyUrl) {
        return urlRepository.findByTinyUrl(tinyUrl).getOriginalUrl();
    }

    private String generateHashString(UrlDto urlDto) {
        String[] url = urlDto.getUrl().split("/");
        StringBuilder id = new StringBuilder();
        for(int i = 0; i < url.length; i++){
            long temp = (long) url[i].length() * i + 1;
            if(!url[i].isEmpty()){
                id.append(temp).append(url[i].charAt(0));
            }
            else{
                id.append(temp).append(url[i]);
            }

        }
        return id.toString();
    }

     private LocalDateTime getExpireAt(UrlDto urlDto) {
         return  LocalDateTime.now().plusDays(urlDto.getExpireIn());
     }
}
