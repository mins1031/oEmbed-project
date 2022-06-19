package com.min.oEmbedproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.common.DomainInfo2;
import com.min.oEmbedproject.common.UrlParser;
import com.min.oEmbedproject.dto.*;
import com.min.oEmbedproject.exception.NotCollectDataException;
import com.min.oEmbedproject.exception.ParameterException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@Slf4j
@RequiredArgsConstructor
public class OembedService2 {

    private final ObjectMapper objectMapper;
    private final DomainInfo2 domainInfo2;

    //youtube 플랫폼의 oEmbed 서비스에서 원하는 url의 데이터를 받아오는 메서드
    public CollectYoutubeDto extractYouTubeData(String searchUrl, String hostValue) throws Exception {

        if (searchUrl == null || hostValue == null)
            throw new ParameterException();

        String youtubeData = collectOembedData(searchUrl, hostValue);

        CollectYoutubeDto resultYoutubeDto = objectMapper.readValue(youtubeData, CollectYoutubeDto.class);

        return resultYoutubeDto;
    }

    //Instagram 플랫폼의 oEmbed 서비스에서 원하는 url의 데이터를 받아오는 메서드
    public CollectInstagramDto extractInstagramData(String searchUrl, String hostValue) throws Exception {

        if (searchUrl == null || hostValue == null)
            throw new ParameterException();

        String instagramData = collectOembedData(searchUrl, hostValue);

        CollectInstagramDto resultInstagramDTo =
                objectMapper.readValue(instagramData, CollectInstagramDto.class);

        return resultInstagramDTo;
    }

    //Twitter 플랫폼의 oEmbed 서비스에서 원하는 url의 데이터를 받아오는 메서드
    public CollectTwitterDto extractTwitterData(String searchUrl, String hostValue) throws Exception {
        String twitterData = collectOembedData(searchUrl, hostValue);

        CollectTwitterDto resultTwitterDto =
                objectMapper.readValue(twitterData, CollectTwitterDto.class);

        return resultTwitterDto;
    }

    //Vimeo 플랫폼의 oEmbed 서비스에서 원하는 url의 데이터를 받아오는 메서드
    public CollectVimeoDto extractVimeoData(String searchUrl, String hostValue) throws Exception {

        if (searchUrl == null || hostValue == null)
            throw new ParameterException();

        String vimeoData = collectOembedData(searchUrl, hostValue);

        CollectVimeoDto resultVimeoDto =
                objectMapper.readValue(vimeoData, CollectVimeoDto.class);

        return resultVimeoDto;
    }

    //플랫폼의 oEmbed 서비스에서 원하는 url의 데이터를 받아오는 메서드
    private String collectOembedData(String searchUrl, String hostValue) {

        BufferedReader in = null;

        String completeOembedUrl = distinguishUrlHost(hostValue, searchUrl);
        String resultData = null;

        try {
            URL resultUrl = new URL(completeOembedUrl);
            HttpURLConnection con = (HttpURLConnection) resultUrl.openConnection();
            con.setRequestMethod("GET");

            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

            String line;

            while ((line = in.readLine()) != null) {
                resultData = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.info(e.getMessage());
            throw new NotCollectDataException(e);
        }

        return resultData;
    }

    //요청된 url의 플랫폼을 기반으로 플랫폼에 맞는 oEmbed요청 url을 생성,리턴해주는 메서드
    public String distinguishUrlHost(String hostInfo, String searchUrl) {
        String completeUrl = null;

        if (hostInfo.equals(domainInfo2.getCheckYoutube()))
            completeUrl = UrlParser.MadeYoutubeOembedUrl(searchUrl).toString();
        else if (hostInfo.equals(domainInfo2.getCheckInstagram()))
            completeUrl = UrlParser.MadeInstagramOembedUrl(searchUrl).toString();
        else if (hostInfo.equals(domainInfo2.getCheckTwitter()))
            completeUrl = UrlParser.MadeTwitterOembedUrl(searchUrl).toString();
        else if (hostInfo.equals(domainInfo2.getCheckVimeo()))
            completeUrl = UrlParser.MadeVimeoOembedUrl(searchUrl).toString();
        return completeUrl;
    }

}
