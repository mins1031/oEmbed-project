package com.min.oEmbedproject.v2.oembeded.controller;

import com.min.oEmbedproject.v2.oembeded.service.OembedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OembedController {

    private final OembedService oembedService;

    @GetMapping("/v2/api/oembed")
    public ResponseEntity getOembedData(@RequestParam("url") String searchUrl) throws Exception {

        oembedService.beProvidedOembededData(searchUrl);
        return null;
    }
}
