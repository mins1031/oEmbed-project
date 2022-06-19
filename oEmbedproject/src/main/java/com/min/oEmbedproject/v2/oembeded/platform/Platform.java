package com.min.oEmbedproject.v2.oembeded.platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.v2.oembeded.dto.response.PlatformResponse;

public interface Platform {
    PlatformResponse generatePlatformOembeded(String searchUrl, ObjectMapper objectMapper);

    String makeOembedUrl(String searchUrl);
}
