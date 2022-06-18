package com.min.oEmbedproject.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.min.oEmbedproject.service.OembedService2;
import com.min.oEmbedproject.testconfig.RestDocsConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Import(RestDocsConfiguration.class)
class OembedControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    OembedService2 oembedService2;

    @Test
    @DisplayName("컨트롤러 youtube테스트")
    public void youtubeOEmbedControllerTest() throws Exception {
        //Given
        String testUrl = "https://www.youtube.com/watch?v=dBD54EZIrZo";

        //When & Then
        this.mockMvc.perform(get("/api/oembed?url=" + testUrl)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("title").exists())
                .andExpect(jsonPath("author_name").exists())
                .andExpect(jsonPath("author_url").exists())
                .andExpect(jsonPath("type").exists())
                .andExpect(jsonPath("height").exists())
                .andExpect(jsonPath("width").exists())
                .andExpect(jsonPath("version").exists())
                .andExpect(jsonPath("provider_name").exists())
                .andExpect(jsonPath("provider_url").exists())
                .andExpect(jsonPath("thumbnail_height").exists())
                .andExpect(jsonPath("thumbnail_width").exists())
                .andExpect(jsonPath("thumbnail_url").exists())
                .andExpect(jsonPath("html").exists())
        .andDo(document("youtube-oembed",
                requestHeaders(
                        headerWithName(HttpHeaders.CONTENT_TYPE).description("application/json")
                ),
                requestParameters(
                        parameterWithName("url").description("oEebed데이터를 요청할 url")
                ),
                responseHeaders(
                        headerWithName(HttpHeaders.CONTENT_TYPE).description("application/json")
                ),
                responseFields(
                        fieldWithPath("title").description("유튜브 리소스 제목"),
                        fieldWithPath("author_name").description("리소스 업로더 이름"),
                        fieldWithPath("author_url").description("리소스 업로더 url"),
                        fieldWithPath("type").description("리소스의 유형"),
                        fieldWithPath("height").description("html을 표시하는데 필요한 높이(픽셀)"),
                        fieldWithPath("width").description("html을 표시하는데 필요한 너비(픽셀)"),
                        fieldWithPath("version").description("oEmbed의 버전정보"),
                        fieldWithPath("provider_name").description("oEmbed제공 서비스 이름 정보"),
                        fieldWithPath("provider_url").description("oEmbed제공 서비스 url 정보"),
                        fieldWithPath("thumbnail_height").description("썸네일 높이 정보"),
                        fieldWithPath("thumbnail_width").description("썸네일 폭 정보"),
                        fieldWithPath("thumbnail_url").description("썸네일 주소 정보"),
                        fieldWithPath("html").description("html 형태로 영상출력")

                )
                ))
        ;
    }

    @Test
    @DisplayName("컨트롤러 insta 테스트")
    public void instaOEmbedControllerTest() throws Exception {
        //Given
        String testUrl = "https://www.instagram.com/p/BUawPlPF_Rx/";

        //When & Then
        this.mockMvc.perform(get("/api/oembed?url=" + testUrl)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("version").exists())
                .andExpect(jsonPath("title").exists())
                .andExpect(jsonPath("author_name").exists())
                .andExpect(jsonPath("author_url").exists())
                .andExpect(jsonPath("author_id").exists())
                .andExpect(jsonPath("media_id").exists())
                .andExpect(jsonPath("provider_name").exists())
                .andExpect(jsonPath("provider_url").exists())
                .andExpect(jsonPath("type").exists())
                .andExpect(jsonPath("width").exists())
                .andExpect(jsonPath("height").exists())
                .andExpect(jsonPath("version").exists())
                .andExpect(jsonPath("html").exists())
                .andExpect(jsonPath("thumbnail_url").exists())
                .andExpect(jsonPath("thumbnail_width").exists())
                .andExpect(jsonPath("thumbnail_height").exists())
                .andDo(document("insta-oembed",
                        requestHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("application/json")
                        ),
                        requestParameters(
                                parameterWithName("url").description("oEebed데이터를 요청할 url")
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("application/json")
                        ),
                        responseFields(
                                fieldWithPath("version").description("oEmbed의 버전정보"),
                                fieldWithPath("title").description("인스타 리소스 제목"),
                                fieldWithPath("author_name").description("리소스 업로더 이름"),
                                fieldWithPath("author_url").description("리소스 업로더 url"),
                                fieldWithPath("author_id").description("리소스 업로더 id"),
                                fieldWithPath("media_id").description("미디어 id 정보"),
                                fieldWithPath("provider_name").description("oEmbed제공 서비스 이름 정보"),
                                fieldWithPath("provider_url").description("oEmbed제공 서비스 url 정보"),
                                fieldWithPath("type").description("리소스의 유형"),
                                fieldWithPath("width").description("html을 표시하는데 필요한 너비(픽셀)"),
                                fieldWithPath("height").description("html을 표시하는데 필요한 높이(픽셀)"),
                                fieldWithPath("html").description("html 형태로 영상출력"),
                                fieldWithPath("thumbnail_url").description("썸네일 주소 정보"),
                                fieldWithPath("thumbnail_width").description("썸네일 폭 정보"),
                                fieldWithPath("thumbnail_height").description("썸네일 높이 정보")
                        )
                ))
        ;
    }

    @Test
    @DisplayName("컨트롤러 twitter 테스트")
    public void twitterOEmbedControllerTest() throws Exception {
        //Given
        String testUrl = "https://twitter.com/hellopolicy/status/867177144815804416";

        //When & Then
        this.mockMvc.perform(get("/api/oembed?url=" + testUrl)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("url").exists())
                .andExpect(jsonPath("author_name").exists())
                .andExpect(jsonPath("author_url").exists())
                .andExpect(jsonPath("html").exists())
                .andExpect(jsonPath("width").exists())
                .andExpect(jsonPath("height").exists())
                .andExpect(jsonPath("type").exists())
                .andExpect(jsonPath("cache_age").exists())
                .andExpect(jsonPath("provider_name").exists())
                .andExpect(jsonPath("provider_url").exists())
                .andExpect(jsonPath("version").exists())
                .andDo(document("twitter-oembed",
                        requestHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("application/json")
                        ),
                        requestParameters(
                                parameterWithName("url").description("oEebed데이터를 요청할 url")
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("application/json")
                        ),
                        responseFields(
                                fieldWithPath("url").description("이미지 리소스 url"),
                                fieldWithPath("author_name").description("리소스 업로더 이름"),
                                fieldWithPath("author_url").description("리소스 업로더 url"),
                                fieldWithPath("html").description("html 형태로 게시물출력"),
                                fieldWithPath("width").description("html을 표시하는데 필요한 너비(픽셀)"),
                                fieldWithPath("height").description("html을 표시하는데 필요한 높이(픽셀)"),
                                fieldWithPath("type").description("리소스의 유형"),
                                fieldWithPath("cache_age").description("초단위로 설정된 해당 리소스 캐시의 라이프타임 정보"),
                                fieldWithPath("provider_name").description("oEmbed제공 서비스 이름 정보"),
                                fieldWithPath("provider_url").description("oEmbed제공 서비스 url 정보"),
                                fieldWithPath("version").description("oEmbed의 버전정보")
                        )
                ))
        ;
    }

    @Test
    @DisplayName("컨트롤러 vimeo 테스트")
    public void vimeoOEmbedControllerTest() throws Exception {
        //Given
        String testUrl = "https://vimeo.com/20097015";

        //When & Then
        this.mockMvc.perform(get("/api/oembed?url=" + testUrl)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("type").exists())
                .andExpect(jsonPath("version").exists())
                .andExpect(jsonPath("provider_name").exists())
                .andExpect(jsonPath("provider_url").exists())
                .andExpect(jsonPath("title").exists())
                .andExpect(jsonPath("author_name").exists())
                .andExpect(jsonPath("author_url").exists())
                .andExpect(jsonPath("is_plus").exists())
                .andExpect(jsonPath("account_type").exists())
                .andExpect(jsonPath("html").exists())
                .andExpect(jsonPath("width").exists())
                .andExpect(jsonPath("height").exists())
                .andExpect(jsonPath("duration").exists())
                .andExpect(jsonPath("description").exists())
                .andExpect(jsonPath("thumbnail_width").exists())
                .andExpect(jsonPath("thumbnail_url").exists())
                .andExpect(jsonPath("thumbnail_height").exists())
                .andExpect(jsonPath("upload_date").exists())
                .andExpect(jsonPath("video_id").exists())
                .andExpect(jsonPath("uri").exists())
                .andDo(document("vimeo-oembed",
                        requestHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("application/json")
                        ),
                        requestParameters(
                                parameterWithName("url").description("oEebed데이터를 요청할 url")
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("application/json")
                        ),
                        responseFields(
                                fieldWithPath("type").description("리소스의 유형"),
                                fieldWithPath("version").description("oEmbed의 버전정보"),
                                fieldWithPath("provider_name").description("oEmbed제공 서비스 이름 정보"),
                                fieldWithPath("provider_url").description("oEmbed제공 서비스 url 정보"),
                                fieldWithPath("title").description("vimeo 리소스 제목"),
                                fieldWithPath("author_name").description("리소스 업로더 이름"),
                                fieldWithPath("author_url").description("리소스 업로더 url"),
                                fieldWithPath("is_plus").description("어떠한 정보인지 파악불가"),
                                fieldWithPath("account_type").description("어떠한 정보인지 파악불가"),
                                fieldWithPath("html").description("html 형태로 영상출력"),
                                fieldWithPath("width").description("html을 표시하는데 필요한 너비(픽셀)"),
                                fieldWithPath("height").description("html을 표시하는데 필요한 높이(픽셀)"),
                                fieldWithPath("duration").description("지속기간"),
                                fieldWithPath("description").description("리소스에 대한 설명"),
                                fieldWithPath("thumbnail_url").description("썸네일 주소 정보"),
                                fieldWithPath("thumbnail_width").description("썸네일 폭 정보"),
                                fieldWithPath("thumbnail_height").description("썸네일 높이 정보"),
                                fieldWithPath("thumbnail_url_with_play_button").description("재생버튼의 url정보"),
                                fieldWithPath("upload_date").description("최근 업데이트 날짜 정보"),
                                fieldWithPath("video_id").description("해당 리소스에 할당된 id"),
                                fieldWithPath("uri").description("해당 리소스의 uri")

                        )
                ))
        ;
    }

    @Test
    @DisplayName("Wrong_parameter(거의 url이 '',' ',null 인경우) 에러 테스트")
    void wrongParameterTest() throws Exception{
        //Given
        String nullParameter = null;
        String emptyParameter = "";
        String blankParameter = " ";

        //When & Then
        this.mockMvc.perform(get("/api/oembed?url=" + blankParameter)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value(470))
                .andExpect(jsonPath("exceptionCode").exists())
                .andExpect(jsonPath("exceptionCode").value("A001"))
                .andExpect(jsonPath("message").exists())
        ;
    }

    @Test
    @DisplayName("Wrong_url(도메인은 있으나 url이 존재하지 않는경우 IOExcetion) 에러 테스트")
    void wrongUrlTest() throws Exception{
        //Given
        String wrongUrl = "https://www.youtube.com/watch?v=XQyuS6zVn";

        //When & Then
        this.mockMvc.perform(get("/api/oembed?url=" + wrongUrl)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value(480))
                .andExpect(jsonPath("exceptionCode").exists())
                .andExpect(jsonPath("exceptionCode").value("A002"))
                .andExpect(jsonPath("message").exists())
        ;
    }

    @Test
    @DisplayName("Wrong_domain(존재하지 않는 도메인인 경우) 에러 테스트")
    void wrongDomainTest() throws Exception{
        //Given
        String wrongDomain = "https://hianna.tistory.com/603";

        //When & Then
        this.mockMvc.perform(get("/api/oembed?url=" + wrongDomain)
        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value(490))
                .andExpect(jsonPath("exceptionCode").exists())
                .andExpect(jsonPath("exceptionCode").value("A003"))
                .andExpect(jsonPath("message").exists())
        ;
    }
}