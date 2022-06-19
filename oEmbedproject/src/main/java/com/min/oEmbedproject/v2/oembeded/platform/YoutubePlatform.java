package com.min.oEmbedproject.v2.oembeded.platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.common.UrlParser;
import com.min.oEmbedproject.v2.oembeded.common.OembededDispatcher;
import com.min.oEmbedproject.v2.oembeded.dto.YoutubeOembededResponse;
import com.min.oEmbedproject.v2.oembeded.dto.response.PlatformResponse;
import com.min.oEmbedproject.v2.oembeded.exception.ConversionResponseException;

public class YoutubePlatform implements Platform {

    @Override
    public PlatformResponse<YoutubeOembededResponse> generatePlatformOembeded(String searchUrl, ObjectMapper objectMapper) {

        String youtubeOembedUrl = makeOembedUrl(searchUrl);
        String youtubeOembededRawResult = OembededDispatcher.collectOembedData(youtubeOembedUrl);
        YoutubeOembededResponse youtubeOembededResponse = toYoutubeOembededResponse(youtubeOembededRawResult, objectMapper);

        return new PlatformResponse<YoutubeOembededResponse>(youtubeOembededResponse);
    }

    @Override
    public String makeOembedUrl(String searchUrl){
        StringBuffer completeYoutubeOembedUrl = new StringBuffer();
        completeYoutubeOembedUrl.insert(0, UrlParser.YOUTUBE_OEMBED_URL).append(searchUrl).append(UrlParser.CONTENT_FORMAT);

        return completeYoutubeOembedUrl.toString();
    }

    private YoutubeOembededResponse toYoutubeOembededResponse(String youtubeOembededRawResult, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(youtubeOembededRawResult, YoutubeOembededResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConversionResponseException("YoutubeOembededResponse 변환이 실패했습니다.");
        }
    }
}
