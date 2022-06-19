package com.min.oEmbedproject.service;

import com.min.oEmbedproject.dto.*;
import com.min.oEmbedproject.exception.NotCollectDataException;
import com.min.oEmbedproject.exception.ParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OembedService2Test {

    @Autowired
    OembedService2 oembedService2;

    @Test
    @DisplayName("youtube url받고 알맞는 oEmbed값을 받아와 DTO변환")
    void  youtubeCollectOembedDataTest() throws Exception {
        //Given
        String youtubeUrl = "https://www.youtube.com/watch?v=dBD54EZIrZo";

        URL hostUrl = new URL(youtubeUrl);
        String hostValue = hostUrl.getHost();

        //When
        CollectYoutubeDto collectYoutubeDto = oembedService2.extractYouTubeData(youtubeUrl,hostValue);

        System.out.println("dto= " +collectYoutubeDto);

        //Then
        assertEquals(collectYoutubeDto.getClass(),CollectYoutubeDto.class);
    }

    @Test
    @DisplayName("insta url받고 알맞는 oEmbed값을 받아와 DTO변환")
    void instaCollectOembedDataTest() throws Exception{
        //Given
        String instaUrl = "https://www.instagram.com/p/BUawPlPF_Rx/";

        URL hostUrl = new URL(instaUrl);
        String hostValue = hostUrl.getHost();

        //When
        CollectInstagramDto collectInstagramDto = oembedService2.extractInstagramData(instaUrl,hostValue);

        System.out.println("dto= " +collectInstagramDto);

        //Then
        assertEquals(collectInstagramDto.getClass(),CollectInstagramDto.class);
    }

    @Test
    @DisplayName("twitter url받고 알맞는 oEmbed값을 받아와 DTO변환")
    void twitterCollectOembedDataTest() throws Exception{
        //Given
        String twitterUrl = "https://vimeo.com/20097015";

        URL hostUrl = new URL(twitterUrl);
        String hostValue = hostUrl.getHost();

        //When
        CollectTwitterDto collectTwitterDto = oembedService2.extractTwitterData(twitterUrl,hostValue);

        System.out.println("dto= " +collectTwitterDto);

        //Then
        assertEquals(collectTwitterDto.getClass(), CollectTwitterDto.class);
    }

    @Test
    @DisplayName("vimeo url받고 알맞는 oEmbed값을 받아와 DTO변환")
    void vimeoCollectOembedDataTest() throws Exception{
        //Given
        String vimeoUrl = "https://vimeo.com/20097015";

        URL hostUrl = new URL(vimeoUrl);
        String hostValue = hostUrl.getHost();

        //When
        CollectVimeoDto collectVimeoDto = oembedService2.extractVimeoData(vimeoUrl,hostValue);

        System.out.println("dto= " +collectVimeoDto);

        //Then
        assertEquals(collectVimeoDto.getClass(),CollectVimeoDto.class);
    }

    @Test
    @DisplayName("잘못된 url받은 경우 테스트")
    void wrongUrlTest() throws Exception{
        //Given
        String vimeoUrl = "https://";

        URL hostUrl = new URL(vimeoUrl);
        String hostValue = hostUrl.getHost();

        //When & Then
        assertThrows(NotCollectDataException.class,
                () -> oembedService2.extractVimeoData(vimeoUrl,hostValue));

    }

    @Test
    @DisplayName("파라미터가 null인 경우 테스트")
    void wrongParameterTest() throws Exception{
        //Given
        String vimeoUrl = "https://";

        URL hostUrl = new URL(vimeoUrl);
        String hostValue = hostUrl.getHost();

        //When & Then
        assertThrows(ParameterException.class,
                () -> oembedService2.extractVimeoData(null,hostValue));
        assertThrows(ParameterException.class,
                () -> oembedService2.extractVimeoData(vimeoUrl,null));
        assertThrows(ParameterException.class,
                () -> oembedService2.extractVimeoData(null,null));

    }

}