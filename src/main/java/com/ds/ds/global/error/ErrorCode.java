package com.ds.ds.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    PASSWORD_NOT_MATCH(400, "Password 가 일치하지 않습니다."),
    INVALID_AUTH_CODE(400, "올바르지 않는 인증코드입니다."),
    NOT_AUTHENTICATED(400, "인증되지 않는 이메일입니다."),
    NOT_FOUND_EMAIL(400, "존재하지 않는 이메일입니다."),
    GROUP_PASSWORD_NOT_MATCH(400, "그룹의 비밀번호가 일치하지 않습니다."),
    PASSWORD_IS_EMPTY(400, "패스워드의 값이 비워있습니다."),
    INVALID_MAX_COUNT(400, "올바르지 않는 MaxCount 입니다."),
    EXPIRED_TOKEN(401, "만료된 토큰 입니다."),
    INVALID_TOKEN(401, "유효하지 않는 토큰입니다."),
    UNAUTHORIZED(401, "권한이 없습니다."),
    INVALID_JWT_SIGNATURE(401, "올바르지 않는 서명입니다."),
    UNSUPPORTED_JWT(401, "지원되지 않는 JWT 토큰입니다."),
    ILLEGAL_ARGUMENT_JWT(401, "JWT 토큰이 잘못되었습니다."),
    GROUP_BOSS(403, "당신은 그룹의 보스입니다."),
    USER_NOT_MEMBER(403,"멤버가 아닙니다."),
    NOT_BOSS(403, "방장이 아닙니다."),
    NOT_GROUP_MEMBER(403, "그룹의 멤버가 아닙니다."),
    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다."),
    GROUP_NOT_FOUND(404, "그룹을 찾을 수 없습니다."),
    DUPLICATE_NAME(409, "이미 존재하는 닉네임입니다."),
    DUPLICATE_EMAIL(409, "이미 존재하는 이메일입니다."),
    DUPLICATE_JOIN_GROUP(409, "이미 가입된 그룹입니다."),
    BLACKLIST_ALREADY_EXIST(409, "이미 블랙리스트에 등록되어있습니다."),
    ALREADY_BOSS(409, "이미 방장입니다."),

    INTERNAL_SERVER_ERROR(500, "internal server error");

    private final int status;
    private final String message;
}
