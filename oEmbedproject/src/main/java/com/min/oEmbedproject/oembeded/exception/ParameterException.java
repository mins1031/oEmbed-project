package com.min.oEmbedproject.oembeded.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParameterException extends RuntimeException{

    private static final String MESSAGE = "파라미터의 값이 null이거나 부적절합니다.";

    public ParameterException() {
        super(MESSAGE);
    }
}
