package com.min.oEmbedproject.v2.oembeded.controller;

import com.min.oEmbedproject.common.DomainInfo;
import com.min.oEmbedproject.exception.ParameterException;
import com.min.oEmbedproject.v2.oembeded.service.OembedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OembedController {

    private final OembedService oembedService;
    private final DomainInfo domainInfo;

    @GetMapping("/api/oembed")
    public ResponseEntity getOembedData(@RequestParam("url") String searchUrl) {

        if (searchUrl.isBlank())
            throw new ParameterException();

        String requestUrl = searchUrl;
        String hostValue = null;

        URL hostUrl = new URL(requestUrl);
        hostValue = hostUrl.getHost();

        oembedService.

    }

}
