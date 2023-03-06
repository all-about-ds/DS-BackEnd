package com.ds.ds.global.security.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class IllegalArgumentJwtTokenException extends GlobalException {
    public IllegalArgumentJwtTokenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
