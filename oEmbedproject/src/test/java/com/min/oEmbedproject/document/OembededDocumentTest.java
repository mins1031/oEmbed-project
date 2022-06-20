package com.min.oEmbedproject.document;

import com.min.oEmbedproject.common.DocumentTestConfig;
import com.min.oEmbedproject.oembeded.controller.OembedControllerPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OembededDocumentTest extends DocumentTestConfig {

    @Test
    @DisplayName("유튜브 Oembeded 정보제공 문서화")
    void 유튜브_Oembeded_문서화() throws Exception {
        //Given
        String testUrl = "https://www.youtube.com/watch?v=dBD54EZIrZo";
        StringBuffer path = new StringBuffer();
        path.append(OembedControllerPath.OEMBEDED_FIND_PATH).append("?url=" + testUrl);

        //When & Then
        this.mockMvc.perform(get(path.toString())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
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
                                fieldWithPath("platformOembededResponse.title").description("유튜브 리소스 제목"),
                                fieldWithPath("platformOembededResponse.author_name").description("리소스 업로더 이름"),
                                fieldWithPath("platformOembededResponse.author_url").description("리소스 업로더 url"),
                                fieldWithPath("platformOembededResponse.type").description("리소스의 유형"),
                                fieldWithPath("platformOembededResponse.height").description("html을 표시하는데 필요한 높이(픽셀)"),
                                fieldWithPath("platformOembededResponse.width").description("html을 표시하는데 필요한 너비(픽셀)"),
                                fieldWithPath("platformOembededResponse.version").description("oEmbed의 버전정보"),
                                fieldWithPath("platformOembededResponse.provider_name").description("oEmbed제공 서비스 이름 정보"),
                                fieldWithPath("platformOembededResponse.provider_url").description("oEmbed제공 서비스 url 정보"),
                                fieldWithPath("platformOembededResponse.thumbnail_height").description("썸네일 높이 정보"),
                                fieldWithPath("platformOembededResponse.thumbnail_width").description("썸네일 폭 정보"),
                                fieldWithPath("platformOembededResponse.thumbnail_url").description("썸네일 주소 정보"),
                                fieldWithPath("platformOembededResponse.html").description("html 형태로 영상출력"))
                ))
        ;
    }

//    @Test
    @DisplayName("인스타그램 Oembeded 정보 제공 문서화")
    void 인스타그램_Oembeded_문서화() throws Exception {
        //Given
        String testUrl = "https://www.instagram.com/p/BUawPlPF_Rx/";
        StringBuffer path = new StringBuffer();
        path.append(OembedControllerPath.OEMBEDED_FIND_PATH).append("?url=" + testUrl);

        //When & Then
        this.mockMvc.perform(get(path.toString())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
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
                                fieldWithPath("platformOembededResponse.version").description("oEmbed의 버전정보"),
                                fieldWithPath("platformOembededResponse.title").description("인스타 리소스 제목"),
                                fieldWithPath("platformOembededResponse.author_name").description("리소스 업로더 이름"),
                                fieldWithPath("platformOembededResponse.author_url").description("리소스 업로더 url"),
                                fieldWithPath("platformOembededResponse.author_id").description("리소스 업로더 id"),
                                fieldWithPath("platformOembededResponse.media_id").description("미디어 id 정보"),
                                fieldWithPath("platformOembededResponse.provider_name").description("oEmbed제공 서비스 이름 정보"),
                                fieldWithPath("platformOembededResponse.provider_url").description("oEmbed제공 서비스 url 정보"),
                                fieldWithPath("platformOembededResponse.type").description("리소스의 유형"),
                                fieldWithPath("platformOembededResponse.width").description("html을 표시하는데 필요한 너비(픽셀)"),
                                fieldWithPath("platformOembededResponse.height").description("html을 표시하는데 필요한 높이(픽셀)"),
                                fieldWithPath("platformOembededResponse.html").description("html 형태로 영상출력"),
                                fieldWithPath("platformOembededResponse.thumbnail_url").description("썸네일 주소 정보"),
                                fieldWithPath("platformOembededResponse.thumbnail_width").description("썸네일 폭 정보"),
                                fieldWithPath("platformOembededResponse.thumbnail_height").description("썸네일 높이 정보")
                        )
                ))
        ;
    }

    @Test
    @DisplayName("트위터 Oembeded 정보 제공 문서화")
    void 트위터_Oembeded_문서화() throws Exception {
        //Given
        String testUrl = "https://twitter.com/hellopolicy/status/867177144815804416";
        StringBuffer path = new StringBuffer();
        path.append(OembedControllerPath.OEMBEDED_FIND_PATH).append("?url=" + testUrl);

        //When & Then
        this.mockMvc.perform(get(path.toString())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
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
                                fieldWithPath("platformOembededResponse.url").description("이미지 리소스 url"),
                                fieldWithPath("platformOembededResponse.author_name").description("리소스 업로더 이름"),
                                fieldWithPath("platformOembededResponse.author_url").description("리소스 업로더 url"),
                                fieldWithPath("platformOembededResponse.html").description("html 형태로 게시물출력"),
                                fieldWithPath("platformOembededResponse.width").description("html을 표시하는데 필요한 너비(픽셀)"),
                                fieldWithPath("platformOembededResponse.height").description("html을 표시하는데 필요한 높이(픽셀)"),
                                fieldWithPath("platformOembededResponse.type").description("리소스의 유형"),
                                fieldWithPath("platformOembededResponse.cache_age").description("초단위로 설정된 해당 리소스 캐시의 라이프타임 정보"),
                                fieldWithPath("platformOembededResponse.provider_name").description("oEmbed제공 서비스 이름 정보"),
                                fieldWithPath("platformOembededResponse.provider_url").description("oEmbed제공 서비스 url 정보"),
                                fieldWithPath("platformOembededResponse.version").description("oEmbed의 버전정보")
                        )
                ))
        ;
    }

    @Test
    @DisplayName("Vimoe Oembeded 정보 제공 문서화")
    void Vimoe_Oembeded_문서화() throws Exception {
        //Given
        String testUrl = "https://vimeo.com/20097015";
        StringBuffer path = new StringBuffer();
        path.append(OembedControllerPath.OEMBEDED_FIND_PATH).append("?url=" + testUrl);

        //When & Then
        this.mockMvc.perform(get(path.toString())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
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
                                fieldWithPath("platformOembededResponse.type").description("리소스의 유형"),
                                fieldWithPath("platformOembededResponse.version").description("oEmbed의 버전정보"),
                                fieldWithPath("platformOembededResponse.provider_name").description("oEmbed제공 서비스 이름 정보"),
                                fieldWithPath("platformOembededResponse.provider_url").description("oEmbed제공 서비스 url 정보"),
                                fieldWithPath("platformOembededResponse.title").description("vimeo 리소스 제목"),
                                fieldWithPath("platformOembededResponse.author_name").description("리소스 업로더 이름"),
                                fieldWithPath("platformOembededResponse.author_url").description("리소스 업로더 url"),
                                fieldWithPath("platformOembededResponse.is_plus").description("어떠한 정보인지 파악불가"),
                                fieldWithPath("platformOembededResponse.account_type").description("어떠한 정보인지 파악불가"),
                                fieldWithPath("platformOembededResponse.html").description("html 형태로 영상출력"),
                                fieldWithPath("platformOembededResponse.width").description("html을 표시하는데 필요한 너비(픽셀)"),
                                fieldWithPath("platformOembededResponse.height").description("html을 표시하는데 필요한 높이(픽셀)"),
                                fieldWithPath("platformOembededResponse.duration").description("지속기간"),
                                fieldWithPath("platformOembededResponse.description").description("리소스에 대한 설명"),
                                fieldWithPath("platformOembededResponse.thumbnail_url").description("썸네일 주소 정보"),
                                fieldWithPath("platformOembededResponse.thumbnail_width").description("썸네일 폭 정보"),
                                fieldWithPath("platformOembededResponse.thumbnail_height").description("썸네일 높이 정보"),
                                fieldWithPath("platformOembededResponse.thumbnail_url_with_play_button").description("재생버튼의 url정보"),
                                fieldWithPath("platformOembededResponse.upload_date").description("최근 업데이트 날짜 정보"),
                                fieldWithPath("platformOembededResponse.video_id").description("해당 리소스에 할당된 id"),
                                fieldWithPath("platformOembededResponse.uri").description("해당 리소스의 uri")

                        )
                ))
        ;
    }
}
