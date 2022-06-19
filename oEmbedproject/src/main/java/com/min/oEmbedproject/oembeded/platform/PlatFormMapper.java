package com.min.oEmbedproject.oembeded.platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.oembeded.common.DomainInfo;
import com.min.oEmbedproject.oembeded.dto.response.PlatformResponse;
import com.min.oEmbedproject.oembeded.exception.NotCollectDataException;
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
        platFormOEmbededMapper.put(DomainInfo.INSTAGRAM_DOMAIN, new InstagramPlatform());
        platFormOEmbededMapper.put(DomainInfo.TWITTER_DOMAIN, new TwitterPlatform());
        platFormOEmbededMapper.put(DomainInfo.VIMEO_DOMAIN, new VimeoPlatform());
    }

    public PlatformResponse findOembededResponseByPlatform(String hostUrl, String searchUrl) {
        if (!platFormOEmbededMapper.containsKey(hostUrl)) {
            throw new NotCollectDataException();
        }

        Platform platform = platFormOEmbededMapper.get(hostUrl);
        return platform.generatePlatformOembeded(searchUrl, objectMapper);
    }
}
