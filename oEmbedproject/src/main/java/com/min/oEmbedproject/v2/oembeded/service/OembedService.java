package com.min.oEmbedproject.v2.oembeded.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.common.DomainInfo2;
import com.min.oEmbedproject.common.UrlParser;
import com.min.oEmbedproject.exception.ParameterException;
import com.min.oEmbedproject.v2.oembeded.dto.response.PlatformResponse;
import com.min.oEmbedproject.v2.oembeded.exception.ExtractHostException;
import com.min.oEmbedproject.v2.oembeded.platform.PlatFormMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URL;

@Slf4j
@Service
@RequiredArgsConstructor
public class OembedService {

    private final ObjectMapper objectMapper;
    private final DomainInfo2 domainInfo2;
    private final PlatFormMapper platFormMapper;


    public PlatformResponse beProvidedOembededData(String searchUrl) throws Exception {
        if (searchUrl.isBlank()) {
            throw new ParameterException();
        }

        String hostUrl = extractHost(searchUrl);
        // platformmapper로 hostUrl 보내서 dto 나오게 해야 할듯?
        return platFormMapper.findOembededResponseByPlatform(hostUrl, searchUrl);
    }

    private String extractHost(String searchUrl) throws Exception {
        String hostValue = null;

        try {
            URL hostUrl = new URL(searchUrl);
            hostValue = hostUrl.getHost();

            return hostValue;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExtractHostException();
        }
    }

//    //Instagram 플랫폼의 oEmbed 서비스에서 원하는 url의 데이터를 받아오는 메서드
//    public CollectInstagramDto extractInstagramData(String searchUrl, String hostValue) throws Exception {
//
//        if (searchUrl == null || hostValue == null)
//            throw new ParameterException();
//
//        String instagramData = collectOembedData(searchUrl, hostValue);
//
//        CollectInstagramDto resultInstagramDTo =
//                objectMapper.readValue(instagramData, CollectInstagramDto.class);
//
//        return resultInstagramDTo;
//    }

    //플랫폼의 oEmbed 서비스에서 원하는 url의 데이터를 받아오는 메서드
//    private String collectOembedData(String searchUrl, String hostValue) {
//
//        BufferedReader in = null;
//
//        String completeOembedUrl = distinguishUrlHost(hostValue, searchUrl);
//        String resultData = null;
//
//        try {
//            URL resultUrl = new URL(completeOembedUrl);
//            HttpURLConnection con = (HttpURLConnection) resultUrl.openConnection();
//            con.setRequestMethod("GET");
//
//            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
//
//            String line;
//
//            while ((line = in.readLine()) != null) {
//                resultData = line;
//            }
//
//            return resultData;
//        } catch (IOException e) {
//            e.printStackTrace();
//            log.info(e.getMessage());
//            throw new NotCollectDataException(e);
//        }
//    }

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
