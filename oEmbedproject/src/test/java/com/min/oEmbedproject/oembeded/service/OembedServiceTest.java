package com.min.oEmbedproject.oembeded.service;

import com.min.oEmbedproject.oembeded.dto.TwitterOembededResponse;
import com.min.oEmbedproject.oembeded.dto.InstagramOembededResponse;
import com.min.oEmbedproject.oembeded.dto.VimeoOembededResponse;
import com.min.oEmbedproject.oembeded.dto.YoutubeOembededResponse;
import com.min.oEmbedproject.oembeded.dto.response.PlatformResponse;
import com.min.oEmbedproject.oembeded.exception.NotCollectDataException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OembedServiceTest {

    @Autowired
    private OembedService oembedService;

    @DisplayName("youtube url받고 알맞는 oEmbed값을 받아와 DTO변환")
    @Test
    void 유튜브_Oembeded_조회() throws Exception {
        //given
        String youtubeUrl = "https://www.youtube.com/watch?v=dBD54EZIrZo";

        //When
        PlatformResponse platformResponse = oembedService.beProvidedOembededData(youtubeUrl);

        //Then
        Assertions.assertThat(platformResponse.getPlatformOembededResponse().getClass()).isEqualTo(YoutubeOembededResponse.class);
    }

    @DisplayName("Instagram url받고 알맞는 oEmbed값을 받아와 DTO변환")
//    @Test
    void 인스타그램_Oebeded_조회() throws Exception {
        //given
        //TODO 인스타그램은 현재 어떤 api로 어떻게 통신해야하는지 파악이 잘 안된다.
        String instagramUrl = "https://www.instagram.com/p/BUawPlPF_Rx/";

        //When
        PlatformResponse platformResponse = oembedService.beProvidedOembededData(instagramUrl);

        //Then
        Assertions.assertThat(platformResponse.getPlatformOembededResponse().getClass()).isEqualTo(InstagramOembededResponse.class);
    }

    @DisplayName("Twitter url받고 알맞는 oEmbed값을 받아와 DTO변환")
    @Test
    void 트위터_Oebeded_조회() throws Exception {
        //given
        String instagramUrl = "https://twitter.com/hellopolicy/status/867177144815804416";

        //When
        PlatformResponse platformResponse = oembedService.beProvidedOembededData(instagramUrl);

        //Then
        Assertions.assertThat(platformResponse.getPlatformOembededResponse().getClass()).isEqualTo(TwitterOembededResponse.class);
    }

    @DisplayName("Vimeo url받고 알맞는 oEmbed값을 받아와 DTO변환")
    @Test
    void VIMEO_Oebeded_조회() throws Exception {
        //given
        String instagramUrl = "https://vimeo.com/20097015";

        //When
        PlatformResponse platformResponse = oembedService.beProvidedOembededData(instagramUrl);

        //Then
        Assertions.assertThat(platformResponse.getPlatformOembededResponse().getClass()).isEqualTo(VimeoOembededResponse.class);
    }

    @DisplayName("[예외] oEmbed 서비스를 지원하지 않는 사이트 url로 예외생성")
    @Test
    void 티스토리_Oebeded_조회() throws Exception {
        //given
        String tistoryUrl = "https://fukkifootball.tistory.com/4839";

        //When & Then
        Assertions.assertThatThrownBy(() -> oembedService.beProvidedOembededData(tistoryUrl)).isInstanceOf(NotCollectDataException.class);
    }

}