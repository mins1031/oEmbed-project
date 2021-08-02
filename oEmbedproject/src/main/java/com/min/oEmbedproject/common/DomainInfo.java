package com.min.oEmbedproject.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class DomainInfo {

    private final String checkYoutube = "www.youtube.com";
    private final String checkInstagram = "www.instagram.com";
    private final String checkTwitter = "twitter.com";
    private final String checkVimeo = "vimeo.com";

}
