package com.min.oEmbedproject.v2.oembeded.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.common.DomainInfo2;
import com.min.oEmbedproject.common.UrlParser;
import com.min.oEmbedproject.exception.ParameterException;
import com.min.oEmbedproject.v2.oembeded.dto.response.PlatformResponse;
import com.min.oEmbedproject.v2.oembeded.exception.ExtractHostException;
import com.min.oEmbedproject.v2.oembeded.platform.PlatFormMapper;
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
