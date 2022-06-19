package com.min.oEmbedproject.oembeded.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VimeoOembededResponse {

    private String type;
    private String version;
    @JsonProperty("provider_name")
    private String providerName;
    @JsonProperty("provider_url")
    private String providerUrl;
    private String title;
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("author_url")
    private String authorUrl;
    @JsonProperty("is_plus")
    private int isPlus;
    @JsonProperty("account_type")
    private String accountType;
    private String html;
    private int width;
    private int height;
    private int duration;
    private String description;
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;
    @JsonProperty("thumbnail_height")
    private String thumbnailHeight;
    @JsonProperty("thumbnail_width")
    private String thumbnailWidth;
    @JsonProperty("thumbnail_url_with_play_button")
    private String thumbnailUrlWithPlayButton;
    @JsonProperty("upload_date")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String uploadDate;
    @JsonProperty("video_id")
    private String videoId;
    private String uri;

}
