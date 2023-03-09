package com.ds.ds.domain.auth.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash(value = "AuthCode",timeToLive = 60 * 5L)
public class AuthCode {
    @Id
    @Indexed
    private String email;
    @Indexed
    private String code;

    @Builder
    public AuthCode(String email, String code){
        this.email = email;
        this.code = code;
    }
}
