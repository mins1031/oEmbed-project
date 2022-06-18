package com.min.oEmbedproject.v2.oembeded.service;

import com.min.oEmbedproject.v2.oembeded.dto.YoutubeOembededResponse;
import com.min.oEmbedproject.v2.oembeded.dto.response.PlatformResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URL;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class OembedService2Test {

    @Autowired
    private OembedService oembedService;

    @DisplayName("youtube url받고 알맞는 oEmbed값을 받아와 DTO변환")
    @Test
    void youtubeCollectOembedDataTest() throws Exception {
        //given
        String youtubeUrl = "https://www.youtube.com/watch?v=dBD54EZIrZo";

        //When
        PlatformResponse platformResponse = oembedService.beProvidedOembededData(youtubeUrl);

        //Then
        Assertions.assertThat(platformResponse.getPlatformOembededResponse().getClass()).isEqualTo(YoutubeOembededResponse.class);
    }

}