package com.ds.ds.domain.member.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class AlreadyBossException extends GlobalException {
    public AlreadyBossException(ErrorCode errorCode) {
        super(errorCode);
    }
}
