package com.min.oEmbedproject.v2.oembeded.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.NIP;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TwitterOembededResponse {

    private String url;
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("author_url")
    private String authorUrl;
    private String html;
    private int width;
    private int height;
    private String type;
    @JsonProperty("cache_age")
    private String cacheAge;
    @JsonProperty("provider_name")
    private String providerName;
    @JsonProperty("provider_url")
    private String providerUrl;
    private String version;
}
