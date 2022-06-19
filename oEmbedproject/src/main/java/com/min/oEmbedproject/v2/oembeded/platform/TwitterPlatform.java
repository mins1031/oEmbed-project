package com.min.oEmbedproject.v2.oembeded.platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.v2.oembeded.common.OembededDispatcher;
import com.min.oEmbedproject.v2.oembeded.dto.InstagramOembededResponse;
import com.min.oEmbedproject.v2.oembeded.dto.TwitterOembededResponse;
import com.min.oEmbedproject.v2.oembeded.dto.response.PlatformResponse;
import com.min.oEmbedproject.v2.oembeded.exception.ConversionResponseException;

import static com.min.oEmbedproject.v2.oembeded.platform.InstagramPlatform.INSTAGRAM_OEMBED_URL;

public class TwitterPlatform implements Platform {

    public final static String TWITTER_OEMBED_URL = new String("https://publish.twitter.com/oembed?url=");
    public final static String CONTENT_FORMAT = "&format=json";

    @Override
    public PlatformResponse generatePlatformOembeded(String searchUrl, ObjectMapper objectMapper) {
        String twitterOembedUrl = makeOembedUrl(searchUrl);
        String twitterOembededRawResult = OembededDispatcher.collectOembedData(twitterOembedUrl);
        TwitterOembededResponse twitterOembededResponse = toTwitterOembededResponse(twitterOembededRawResult, objectMapper);

        return new PlatformResponse<TwitterOembededResponse>(twitterOembededResponse);
    }

    @Override
    public String makeOembedUrl(String searchUrl) {
        StringBuffer completeTwitterOembedUrl = new StringBuffer();
        completeTwitterOembedUrl.insert(0,TWITTER_OEMBED_URL).append(searchUrl).append(CONTENT_FORMAT);

        return completeTwitterOembedUrl.toString();
    }

    private TwitterOembededResponse toTwitterOembededResponse(String twitterOembededRawResult, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(twitterOembededRawResult, TwitterOembededResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConversionResponseException("twitterOembededRawResult 변환이 실패했습니다.");
        }
    }
}
