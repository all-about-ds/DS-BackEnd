package com.ds.ds.domain.group.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class NotBossException extends GlobalException {

    public NotBossException(ErrorCode errorCode) {
        super(errorCode);
    }
}
