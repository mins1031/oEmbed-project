package com.min.oEmbedproject.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParameterException extends RuntimeException{

    public ParameterException() {
    }

    public ParameterException(String message) {
        super(message);
        log.error(message);
    }

    @Override
    public String getMessage() {
        return "파라미터의 값이 null이거나 부적절합니다.";
    }
}
