package com.min.oEmbedproject.oembeded.platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.oembeded.common.OembededDispatcher;
import com.min.oEmbedproject.oembeded.dto.YoutubeOembededResponse;
import com.min.oEmbedproject.oembeded.dto.response.PlatformResponse;
import com.min.oEmbedproject.oembeded.exception.ConversionResponseException;

public class YoutubePlatform implements Platform {

    private final static String YOUTUBE_OEMBED_URL = new String("https://www.youtube.com/oembed?url=");
    private final static String CONTENT_FORMAT = "&format=json";

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
        completeYoutubeOembedUrl.insert(0, YOUTUBE_OEMBED_URL).append(searchUrl).append(CONTENT_FORMAT);

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
