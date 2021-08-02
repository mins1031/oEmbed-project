package com.min.oEmbedproject.exception;

import com.min.oEmbedproject.exception.ExceptionResponse;
import lombok.Getter;

@Getter
public enum ExceptionStatusCode {

    WRONG_PARAMETER(470,"A001","파라미터값이 null입니다. 정확한 값을 입력하세요"),
    WRONG_URL(480,"A002","잘못된 url입니다. url을 정확히 입력해 주세요"),
    WRONG_DOMAIN(490,"A003","oEmbed데이터 서비스를 제공하지 않는 도메인 입니다.");

    private int value;
    private String exceptionCode;
    private String message;

    ExceptionStatusCode(int value, String exceptionCode, String message) {
        this.value = value;
        this.exceptionCode = exceptionCode;
        this.message = message;
    }
}
