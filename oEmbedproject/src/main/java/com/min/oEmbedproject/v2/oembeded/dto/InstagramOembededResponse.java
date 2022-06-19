package com.min.oEmbedproject.v2.oembeded.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InstagramOembededResponse {

    private String version;
    private String title;
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("author_url")
    private String authorUrl;
    @JsonProperty("author_id")
    private String authorId;
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("provider_name")
    private String providerName;
    @JsonProperty("provider_url")
    private String providerUrl;
    private String type;
    private int width;
    private int height;
    private String html;
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;
    @JsonProperty("thumbnail_width")
    private String thumbnailWidth;
    @JsonProperty("thumbnail_height")
    private String thumbnailHeight;
}
