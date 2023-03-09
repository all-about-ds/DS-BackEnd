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
@RedisHash(value = "SaveAuthCode")
public class SaveAuthCode {
    @Id
    @Indexed
    private String email;
    @Indexed
    private String code;
    @Indexed
    private boolean authentication;

    @Builder
    public SaveAuthCode(String email, String code, boolean authentication){
        this.email = email;
        this.code = code;
        this.authentication = authentication;
    }
}
