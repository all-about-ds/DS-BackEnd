package com.ds.ds.domain.auth.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class InValidAuthCodeException extends GlobalException {

    public InValidAuthCodeException(ErrorCode errorCode) {
        super(errorCode);
    }
}
