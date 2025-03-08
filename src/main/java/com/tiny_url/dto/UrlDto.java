package com.tiny_url.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlDto {
    @JsonProperty("url")
    private String url;

    @JsonProperty("expireIn")
    private int expireIn;
}
