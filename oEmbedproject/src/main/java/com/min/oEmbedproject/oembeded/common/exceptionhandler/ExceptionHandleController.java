package com.min.oEmbedproject.oembeded.common.exceptionhandler;

import com.min.oEmbedproject.oembeded.common.ExceptionStatusCode;
import com.min.oEmbedproject.oembeded.exception.ExceptionResponse;
import com.min.oEmbedproject.oembeded.exception.NotCollectDataException;
import com.min.oEmbedproject.oembeded.exception.NotRegisterDomainException;
import com.min.oEmbedproject.oembeded.exception.ParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ExceptionHandleController {

    @ExceptionHandler(ParameterException.class)
    public ResponseEntity handleParamaterException() {
        log.info("ParamaterException");
        ExceptionResponse resultResponse = ExceptionResponse.of(ExceptionStatusCode.WRONG_PARAMETER);

        return new ResponseEntity(resultResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotRegisterDomainException.class)
    public ResponseEntity handleNotRegisterDomainException(NotRegisterDomainException e) {
        log.info("message= " + e.getMessage());
        ExceptionResponse resultResponse = ExceptionResponse.of(ExceptionStatusCode.WRONG_DOMAIN);

        return new ResponseEntity(resultResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotCollectDataException.class)
    public ResponseEntity handleNotCollectDataException() {
        log.info("NotCollectDataException");
        ExceptionResponse resultResponse = ExceptionResponse.of(ExceptionStatusCode.WRONG_URL);

        return new ResponseEntity(resultResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException() {
        log.info("IOException");
        ExceptionResponse resultResponse = ExceptionResponse.of(ExceptionStatusCode.WRONG_URL);

        return new ResponseEntity(resultResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException() {
        log.info("Exception");
        ExceptionResponse resultResponse = ExceptionResponse.of(ExceptionStatusCode.WRONG_URL);

        return new ResponseEntity(resultResponse, HttpStatus.BAD_REQUEST);
    }

}
