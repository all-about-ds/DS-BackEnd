package com.ds.ds.domain.auth.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash(value = "RefreshToken", timeToLive = 60L * 60 * 24 * 7)
public class RefreshToken{
    @Id
    @Indexed
    private Long userId;
    @Indexed
    private String token;

    @Builder
    public RefreshToken(Long userId, String token){
        this.userId = userId;
        this.token = token;
    }
}
