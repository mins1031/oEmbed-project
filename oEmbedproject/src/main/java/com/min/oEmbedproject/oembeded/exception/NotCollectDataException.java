package com.min.oEmbedproject.oembeded.exception;

public class NotCollectDataException extends RuntimeException{

    private static final String MESSAGE = "해당 url에서 oEmbed 데이터를 추출할 수 없습니다. url정보가 올바른지 확인해 주세요.";

    public NotCollectDataException() {
        super(MESSAGE);
    }
}
