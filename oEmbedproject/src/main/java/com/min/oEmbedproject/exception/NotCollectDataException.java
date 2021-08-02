package com.min.oEmbedproject.exception;

public class NotCollectDataException extends RuntimeException{


    public NotCollectDataException(Exception e) {
        super(e.getMessage(),e);
    }

    @Override
    public String getMessage() {
        return "해당 url에서 oEmbed 데이터를 추출할 수 없습니다. url정보가 올바른지 확인해 주세요.";
    }
}
