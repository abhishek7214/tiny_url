package com.tiny_url.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UrlDto {

    @NonNull
    private String url;

    private int expireIn;
}
