package com.ds.ds.domain.group.exception;

import com.ds.ds.global.error.ErrorCode;
import com.ds.ds.global.error.exceptions.GlobalException;

public class DuplicateJoinGroup extends GlobalException {
    public DuplicateJoinGroup(ErrorCode errorCode) {
        super(errorCode);
    }
}
