package com.min.oEmbedproject.api;

import com.min.oEmbedproject.common.DomainInfo2;
import com.min.oEmbedproject.dto.*;
import com.min.oEmbedproject.exception.NotRegisterDomainException;
import com.min.oEmbedproject.exception.ParameterException;
import com.min.oEmbedproject.service.OembedService2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/oembed2")
public class OembedApiController {

    private final OembedService2 oembedService2;
    private final DomainInfo2 domainInfo2;

    @GetMapping
    public ResponseEntity getOembedData(
            @RequestParam("url") String searchUrl) throws Exception {

        if (searchUrl.isBlank())
            throw new ParameterException();

        log.info("url search");

        String requestUrl = searchUrl;
        String hostValue = null;

        URL hostUrl = new URL(requestUrl);
        hostValue = hostUrl.getHost();

        if (hostValue.equals(domainInfo2.getCheckYoutube())) {
            CollectYoutubeDto resultYoutubeDto = oembedService2.extractYouTubeData(requestUrl, hostValue);
            log.info("youtube");
            return ResponseEntity.ok().body(resultYoutubeDto);
        } else if (hostValue.equals(domainInfo2.getCheckInstagram())) {
            CollectInstagramDto resultInstagramDto = oembedService2.extractInstagramData(requestUrl, hostValue);
            log.info("insta");
            return ResponseEntity.ok().body(resultInstagramDto);
        } else if (hostValue.equals(domainInfo2.getCheckTwitter())) {
            CollectTwitterDto resultTwitterDto = oembedService2.extractTwitterData(requestUrl, hostValue);
            log.info("twit");
            return ResponseEntity.ok().body(resultTwitterDto);
        } else if (hostValue.equals(domainInfo2.getCheckVimeo())) {
            CollectVimeoDto resultVimeoDto = oembedService2.extractVimeoData(requestUrl, hostValue);
            log.info("vimeo");
            return ResponseEntity.ok().body(resultVimeoDto);
        } else {
            log.info("other domain");
            throw new NotRegisterDomainException();
        }
    }

}
