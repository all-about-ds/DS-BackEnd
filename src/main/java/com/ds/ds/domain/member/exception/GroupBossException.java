package com.ds.ds.domain.member.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class GroupBossException extends GlobalException {
    public GroupBossException(ErrorCode errorCode) {
        super(errorCode);
    }
}
