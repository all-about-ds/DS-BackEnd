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

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> UserNotFoundException(UserNotFoundException e){
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(),errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<ErrorResponse> PasswordNotMatchException(PasswordNotMatchException e){
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(),errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }
    @ExceptionHandler(InValidAuthCodeException.class)
    public ResponseEntity<ErrorResponse> InValidAuthCodeException(InValidAuthCodeException e){
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(),errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }
    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ErrorResponse> DuplicateEmailException(DuplicateEmailException e){
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(),errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }
    @ExceptionHandler(DuplicateNameException.class)
    public ResponseEntity<ErrorResponse> DuplicateNameException(DuplicateNameException e){
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(),errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }
    @ExceptionHandler(ExpiredTokenException.class)
    public ResponseEntity<ErrorResponse> ExpiredTokenException(ExpiredTokenException e){
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(),errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }
}
