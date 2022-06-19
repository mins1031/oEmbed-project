package com.min.oEmbedproject.v2.oembeded.platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.v2.oembeded.common.OembededDispatcher;
import com.min.oEmbedproject.v2.oembeded.dto.InstagramOembededResponse;
import com.min.oEmbedproject.v2.oembeded.dto.response.PlatformResponse;
import com.min.oEmbedproject.v2.oembeded.exception.ConversionResponseException;

public class InstagramPlatform implements Platform {

    public final static String INSTAGRAM_OEMBED_URL = new String("https://api.instagram.com/oembed?url=");
    public final static String CONTENT_FORMAT = "&format=json";

    @Override
    public PlatformResponse generatePlatformOembeded(String searchUrl, ObjectMapper objectMapper) {
        String instagramOembedUrl = makeOembedUrl(searchUrl);
        String instagramOembededRawResult = OembededDispatcher.collectOembedData(instagramOembedUrl);
        InstagramOembededResponse instagramOembededResponse = toInstagramOembededResponse(instagramOembededRawResult, objectMapper);

        return new PlatformResponse<InstagramOembededResponse>(instagramOembededResponse);
    }

    @Override
    public String makeOembedUrl(String searchUrl) {
        StringBuffer completeInstagramOembedUrl = new StringBuffer();
        completeInstagramOembedUrl.insert(0, INSTAGRAM_OEMBED_URL).append(searchUrl).append(CONTENT_FORMAT);

        return completeInstagramOembedUrl.toString();
    }

    private InstagramOembededResponse toInstagramOembededResponse(String instagramOembededRawResult, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(instagramOembededRawResult, InstagramOembededResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConversionResponseException("instagramOembededResponse 변환이 실패했습니다.");
        }
    }
}
