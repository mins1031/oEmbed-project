package com.min.oEmbedproject.v2.oembeded.platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.v2.oembeded.common.OembededDispatcher;
import com.min.oEmbedproject.v2.oembeded.dto.InstagramOembededResponse;
import com.min.oEmbedproject.v2.oembeded.dto.VimeoOembededResponse;
import com.min.oEmbedproject.v2.oembeded.dto.response.PlatformResponse;
import com.min.oEmbedproject.v2.oembeded.exception.ConversionResponseException;

public class VimeoPlatform implements Platform {

    public final static String VIMEO_OEMBED_URL = new String("https://vimeo.com/api/oembed.json?url=");

    @Override
    public PlatformResponse generatePlatformOembeded(String searchUrl, ObjectMapper objectMapper) {
        String instagramOembedUrl = makeOembedUrl(searchUrl);
        String instagramOembededRawResult = OembededDispatcher.collectOembedData(instagramOembedUrl);
        VimeoOembededResponse vimeoOembededResponse = toInstagramOembededResponse(instagramOembededRawResult, objectMapper);

        return new PlatformResponse<VimeoOembededResponse>(vimeoOembededResponse);
    }

    @Override
    public String makeOembedUrl(String searchUrl) {
        StringBuffer completeVimeoOembedUrl = new StringBuffer();
        completeVimeoOembedUrl.insert(0,VIMEO_OEMBED_URL).append(searchUrl);

        return completeVimeoOembedUrl.toString();
    }

    private VimeoOembededResponse toInstagramOembededResponse(String vimeoOembededRawResult, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(vimeoOembededRawResult, VimeoOembededResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConversionResponseException("VimeoOembededResponse 변환이 실패했습니다.");
        }
    }
}
