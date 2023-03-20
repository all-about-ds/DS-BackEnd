package com.ds.ds.domain.group.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class NotGroupMemberException extends GlobalException {
    public NotGroupMemberException(ErrorCode errorCode) {
        super(errorCode);
    }
}
