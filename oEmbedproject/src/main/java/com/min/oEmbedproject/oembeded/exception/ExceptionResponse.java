package com.min.oEmbedproject.oembeded.exception;

import com.min.oEmbedproject.oembeded.common.ExceptionStatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExceptionResponse {


    private int value;
    private String exceptionCode;
    private String message;

    public ExceptionResponse(ExceptionStatusCode code) {
        this.value = code.getValue();
        this.exceptionCode = code.getExceptionCode();
        this.message = code.getMessage();
    }

    public static ExceptionResponse of(ExceptionStatusCode code){
        return new ExceptionResponse(code);
    }

}
