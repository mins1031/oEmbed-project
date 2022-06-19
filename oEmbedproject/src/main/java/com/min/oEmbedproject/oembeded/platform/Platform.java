package com.min.oEmbedproject.oembeded.platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.oembeded.dto.response.PlatformResponse;

public interface Platform {
    PlatformResponse generatePlatformOembeded(String searchUrl, ObjectMapper objectMapper);

    String makeOembedUrl(String searchUrl);
}
