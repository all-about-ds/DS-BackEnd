package com.ds.ds.domain.auth.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class IllegalArgumentJwtTokenException extends GlobalException {
    public IllegalArgumentJwtTokenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
