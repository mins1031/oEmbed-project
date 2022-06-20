package com.min.oEmbedproject.integrate;

import com.min.oEmbedproject.common.IntegrateTestConfig;
import com.min.oEmbedproject.oembeded.controller.OembedControllerPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OembededIntegrateTest extends IntegrateTestConfig {

    @Test
    @DisplayName("유튜브 Oembeded 정보 제공 통합테스트")
    void 유튜브_Oembeded_통합테스트() throws Exception {
        //Given
        String testUrl = "https://www.youtube.com/watch?v=dBD54EZIrZo";
        StringBuffer path = new StringBuffer();
        path.append(OembedControllerPath.OEMBEDED_FIND_PATH).append("?url=" + testUrl);

        //When & Then
        this.mockMvc.perform(get(path.toString())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("platformOembededResponse.title").exists())
                .andExpect(jsonPath("platformOembededResponse.author_name").exists())
                .andExpect(jsonPath("platformOembededResponse.author_url").exists())
                .andExpect(jsonPath("platformOembededResponse.type").exists())
                .andExpect(jsonPath("platformOembededResponse.height").exists())
                .andExpect(jsonPath("platformOembededResponse.width").exists())
                .andExpect(jsonPath("platformOembededResponse.version").exists())
                .andExpect(jsonPath("platformOembededResponse.provider_name").exists())
                .andExpect(jsonPath("platformOembededResponse.provider_url").exists())
                .andExpect(jsonPath("platformOembededResponse.thumbnail_height").exists())
                .andExpect(jsonPath("platformOembededResponse.thumbnail_width").exists())
                .andExpect(jsonPath("platformOembededResponse.thumbnail_url").exists())
                .andExpect(jsonPath("platformOembededResponse.html").exists())
        ;
    }

    //    @Test
    @DisplayName("인스타그램 Oembeded 정보 제공 통합테스트")
    void 인스타그램_Oembeded_통합테스트() throws Exception {
        //Given
        String testUrl = "https://www.instagram.com/p/BUawPlPF_Rx/";
        StringBuffer path = new StringBuffer();
        path.append(OembedControllerPath.OEMBEDED_FIND_PATH).append("?url=" + testUrl);

        //When & Then
        this.mockMvc.perform(get(path.toString())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("platformOembededResponse.version").exists())
                .andExpect(jsonPath("platformOembededResponse.title").exists())
                .andExpect(jsonPath("platformOembededResponse.author_name").exists())
                .andExpect(jsonPath("platformOembededResponse.author_url").exists())
                .andExpect(jsonPath("platformOembededResponse.author_id").exists())
                .andExpect(jsonPath("platformOembededResponse.media_id").exists())
                .andExpect(jsonPath("platformOembededResponse.provider_name").exists())
                .andExpect(jsonPath("platformOembededResponse.provider_url").exists())
                .andExpect(jsonPath("platformOembededResponse.type").exists())
                .andExpect(jsonPath("platformOembededResponse.width").exists())
                .andExpect(jsonPath("platformOembededResponse.height").exists())
                .andExpect(jsonPath("platformOembededResponse.version").exists())
                .andExpect(jsonPath("platformOembededResponse.html").exists())
                .andExpect(jsonPath("platformOembededResponse.thumbnail_url").exists())
                .andExpect(jsonPath("platformOembededResponse.thumbnail_width").exists())
                .andExpect(jsonPath("platformOembededResponse.thumbnail_height").exists())
        ;
    }

    @Test
    @DisplayName("트위터 Oembeded 정보 제공 통합테스트")
    public void 트위터_Oembeded_통합테스트() throws Exception {
        //Given
        String testUrl = "https://twitter.com/hellopolicy/status/867177144815804416";
        StringBuffer path = new StringBuffer();
        path.append(OembedControllerPath.OEMBEDED_FIND_PATH).append("?url=" + testUrl);

        //When & Then
        this.mockMvc.perform(get(path.toString())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("platformOembededResponse.url").exists())
                .andExpect(jsonPath("platformOembededResponse.author_name").exists())
                .andExpect(jsonPath("platformOembededResponse.author_url").exists())
                .andExpect(jsonPath("platformOembededResponse.html").exists())
                .andExpect(jsonPath("platformOembededResponse.width").exists())
                .andExpect(jsonPath("platformOembededResponse.height").exists())
                .andExpect(jsonPath("platformOembededResponse.type").exists())
                .andExpect(jsonPath("platformOembededResponse.cache_age").exists())
                .andExpect(jsonPath("platformOembededResponse.provider_name").exists())
                .andExpect(jsonPath("platformOembededResponse.provider_url").exists())
                .andExpect(jsonPath("platformOembededResponse.version").exists())
        ;
    }

    @Test
    @DisplayName("Vimeo Oembeded 정보 제공 통합테스트")
    void Vimeo_Oembeded_통합테스트() throws Exception {
        //Given
        String testUrl = "https://vimeo.com/20097015";
        StringBuffer path = new StringBuffer();
        path.append(OembedControllerPath.OEMBEDED_FIND_PATH).append("?url=" + testUrl);

        //When & Then
        this.mockMvc.perform(get(path.toString())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("platformOembededResponse.type").exists())
                .andExpect(jsonPath("platformOembededResponse.version").exists())
                .andExpect(jsonPath("platformOembededResponse.provider_name").exists())
                .andExpect(jsonPath("platformOembededResponse.provider_url").exists())
                .andExpect(jsonPath("platformOembededResponse.title").exists())
                .andExpect(jsonPath("platformOembededResponse.author_name").exists())
                .andExpect(jsonPath("platformOembededResponse.author_url").exists())
                .andExpect(jsonPath("platformOembededResponse.is_plus").exists())
                .andExpect(jsonPath("platformOembededResponse.account_type").exists())
                .andExpect(jsonPath("platformOembededResponse.html").exists())
                .andExpect(jsonPath("platformOembededResponse.width").exists())
                .andExpect(jsonPath("platformOembededResponse.height").exists())
                .andExpect(jsonPath("platformOembededResponse.duration").exists())
                .andExpect(jsonPath("platformOembededResponse.description").exists())
                .andExpect(jsonPath("platformOembededResponse.thumbnail_width").exists())
                .andExpect(jsonPath("platformOembededResponse.thumbnail_url").exists())
                .andExpect(jsonPath("platformOembededResponse.thumbnail_height").exists())
                .andExpect(jsonPath("platformOembededResponse.upload_date").exists())
                .andExpect(jsonPath("platformOembededResponse.video_id").exists())
                .andExpect(jsonPath("platformOembededResponse.uri").exists())
        ;
    }

    @Test
    @DisplayName("Wrong_parameter(거의 url이 '',' ',null 인경우) 에러 테스트")
    void 잘못된_파라미터_요청() throws Exception{
        //Given
        String nullParameter = null;
        String emptyParameter = "";
        String blankParameter = " ";

        StringBuffer path = new StringBuffer();
        path.append(OembedControllerPath.OEMBEDED_FIND_PATH).append("?url=" + blankParameter);

        //When & Then
        this.mockMvc.perform(get(path.toString())
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
    void 잘못된_파라미터_요청_없는URL데이터() throws Exception{
        //Given
        String wrongUrl = "https://www.youtube.com/watch?v=XQyuS6zVn";
        StringBuffer path = new StringBuffer();
        path.append(OembedControllerPath.OEMBEDED_FIND_PATH).append("?url=" + wrongUrl);

        //When & Then
        this.mockMvc.perform(get(path.toString())
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
    void 등록되지않은_도메인_요청() throws Exception{
        //Given
        String wrongDomain = "https://hianna.tistory.com/603";

        //When & Then
        this.mockMvc.perform(get("/api/oembed?url=" + wrongDomain)
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
}
