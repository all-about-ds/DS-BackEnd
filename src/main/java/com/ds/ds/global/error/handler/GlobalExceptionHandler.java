package com.ds.ds.global.error.handler;

import com.ds.ds.domain.auth.exception.DuplicateEmailException;
import com.ds.ds.domain.auth.exception.DuplicateNameException;
import com.ds.ds.domain.auth.exception.ExpiredTokenException;
import com.ds.ds.domain.auth.exception.InValidAuthCodeException;
import com.ds.ds.domain.user.exception.PasswordNotMatchException;
import com.ds.ds.domain.user.exception.UserNotFoundException;
import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.ErrorResponse;
import com.ds.ds.global.error.exceptions.GlobalException;
import com.ds.ds.global.security.exception.InvalidJwtSignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(GlobalException e){
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(),errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }
}
