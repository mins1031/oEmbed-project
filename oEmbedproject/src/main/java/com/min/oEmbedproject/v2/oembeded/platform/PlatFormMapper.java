package com.min.oEmbedproject.v2.oembeded.platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.v2.oembeded.common.DomainInfo;
import com.min.oEmbedproject.v2.oembeded.dto.response.PlatformResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
public class PlatFormMapper {
    @Autowired
    private ObjectMapper objectMapper;

    private final Map<String, Platform> platFormOEmbededMapper = new HashMap<>();

    public PlatFormMapper() {
        platFormOEmbededMapper.put(DomainInfo.YOUTUBE_DOMAIN, new YoutubePlatform());
    }

    public PlatformResponse findOembededResponseByPlatform(String hostUrl, String searchUrl) {
        Platform platform = platFormOEmbededMapper.get(hostUrl);
        return platform.generatePlatformOembeded(searchUrl, objectMapper);
    }
}
