package com.min.oEmbedproject.v2.oembeded.exception;

public class ExtractHostException extends RuntimeException {

    private static final String MESSAGE = "요청받은 URL에서 플랫폼 정보를 추출할 수 없습니다.";

    public ExtractHostException() {
        super(MESSAGE);
    }
}
