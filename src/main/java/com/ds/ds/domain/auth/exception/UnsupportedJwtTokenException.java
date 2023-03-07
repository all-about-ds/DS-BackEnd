package com.ds.ds.domain.auth.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class UnsupportedJwtTokenException extends GlobalException {
    public UnsupportedJwtTokenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
