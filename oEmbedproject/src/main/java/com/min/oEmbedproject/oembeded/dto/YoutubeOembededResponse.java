package com.min.oEmbedproject.oembeded.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class YoutubeOembededResponse {

    private String title;
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("author_url")
    private String authorUrl;
    private String type;
    private int height;
    private int width;
    private String version;
    @JsonProperty("provider_name")
    private String providerName;
    @JsonProperty("provider_url")
    private String providerUrl;
    @JsonProperty("thumbnail_height")
    private String thumbnailHeight;
    @JsonProperty("thumbnail_width")
    private String thumbnailWidth;
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;
    private String html;
}
