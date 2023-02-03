package com.ds.ds.global.error.handler;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.ErrorResponse;
import com.ds.ds.global.error.exceptions.GlobalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(GlobalException e){
        ErrorCode errorCode =e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(((ErrorCode) errorCode).getStatus(),errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }
}
