package com.ds.ds.domain.auth.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class InvalidJwtSignatureException extends GlobalException {
    public InvalidJwtSignatureException(ErrorCode errorCode) {
        super(errorCode);
    }
}
