package com.min.oEmbedproject.oembeded.service;

import com.min.oEmbedproject.oembeded.dto.response.PlatformResponse;
import com.min.oEmbedproject.oembeded.exception.ExtractHostException;
import com.min.oEmbedproject.oembeded.exception.ParameterException;
import com.min.oEmbedproject.oembeded.platform.PlatFormMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;

@Slf4j
@Service
@RequiredArgsConstructor
public class OembedService {

    private final PlatFormMapper platFormMapper;

    public PlatformResponse beProvidedOembededData(String searchUrl) throws Exception {
        if (searchUrl.isBlank()) {
            throw new ParameterException();
        }

        String hostUrl = extractHost(searchUrl);

        return platFormMapper.findOembededResponseByPlatform(hostUrl, searchUrl);
    }

    private String extractHost(String searchUrl) throws Exception {
        String hostValue = null;

        try {
            URL hostUrl = new URL(searchUrl);
            hostValue = hostUrl.getHost();

            return hostValue;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExtractHostException();
        }
    }
}
