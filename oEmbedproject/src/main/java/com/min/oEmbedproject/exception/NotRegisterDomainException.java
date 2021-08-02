package com.min.oEmbedproject.exception;

public class NotRegisterDomainException extends Exception{
    @Override
    public String getMessage() {
        return "oEmbed가 등록되지 않은 도메인 입니다.";
    }
}
