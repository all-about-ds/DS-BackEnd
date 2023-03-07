package com.ds.ds.domain.group.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class GroupNotFoundException extends GlobalException {
    public GroupNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
