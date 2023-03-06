package com.ds.ds.domain.auth.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class ExpiredTokenException extends GlobalException {

    public ExpiredTokenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
