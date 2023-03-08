package com.ds.ds.domain.auth.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;


public class NotAuthenticatedException extends GlobalException {
    public NotAuthenticatedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
