package com.ds.ds.domain.group.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class GroupPasswordNotMatchException extends GlobalException {
    public GroupPasswordNotMatchException(ErrorCode errorCode) {
        super(errorCode);
    }
}
