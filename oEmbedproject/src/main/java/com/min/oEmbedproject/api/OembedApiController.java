package com.min.oEmbedproject.api;

import com.min.oEmbedproject.common.DomainInfo;
import com.min.oEmbedproject.dto.*;
import com.min.oEmbedproject.exception.NotRegisterDomainException;
import com.min.oEmbedproject.exception.ParameterException;
import com.min.oEmbedproject.service.OembedService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.net.URL;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/oembed")
public class OembedApiController {

    private final OembedService oembedService;
    private final DomainInfo domainInfo;

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

        if (hostValue.equals(domainInfo.getCheckYoutube())) {
            CollectYoutubeDto resultYoutubeDto = oembedService.extractYouTubeData(requestUrl, hostValue);
            log.info("youtube");
            return ResponseEntity.ok().body(resultYoutubeDto);
        } else if (hostValue.equals(domainInfo.getCheckInstagram())) {
            CollectInstagramDto resultInstagramDto = oembedService.extractInstagramData(requestUrl, hostValue);
            log.info("insta");
            return ResponseEntity.ok().body(resultInstagramDto);
        } else if (hostValue.equals(domainInfo.getCheckTwitter())) {
            CollectTwitterDto resultTwitterDto = oembedService.extractTwitterData(requestUrl, hostValue);
            log.info("twit");
            return ResponseEntity.ok().body(resultTwitterDto);
        } else if (hostValue.equals(domainInfo.getCheckVimeo())) {
            CollectVimeoDto resultVimeoDto = oembedService.extractVimeoData(requestUrl, hostValue);
            log.info("vimeo");
            return ResponseEntity.ok().body(resultVimeoDto);
        } else {
            log.info("other domain");
            throw new NotRegisterDomainException();
        }
    }

}
