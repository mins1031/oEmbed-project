package com.min.oEmbedproject.oembeded.controller;

import com.min.oEmbedproject.oembeded.dto.response.PlatformResponse;
import com.min.oEmbedproject.oembeded.service.OembedService;
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

    @GetMapping(OembedControllerPath.OEMBEDED_FIND_PATH)
    public ResponseEntity<PlatformResponse> getOembedData(@RequestParam("url") String searchUrl) throws Exception {
        PlatformResponse platformResponse = oembedService.beProvidedOembededData(searchUrl);
        return ResponseEntity.ok().body(platformResponse);
    }
}
