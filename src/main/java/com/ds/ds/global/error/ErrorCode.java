package com.ds.ds.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    PASSWORD_NOT_MATCH(400, "패스워드가 일치하지 않습니다."),
    EXPIRED_TOKEN(401, "만료된 토큰 입니다."),
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다."),
    UNAUTHORIZED(401, "권한이 없습니다."),
    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500, "internal server error");

    private final int status;
    private final String message;
}
