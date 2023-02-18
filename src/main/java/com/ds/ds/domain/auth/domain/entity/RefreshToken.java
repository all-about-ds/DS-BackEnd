package com.ds.ds.domain.auth.domain.entity;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash(value = "refreshToken", timeToLive = 7 * 24 * 60 * 60 * 1000)
public class RefreshToken {
    @Id
    @Indexed
    private Long userId;
    @Indexed
    private String token;
}
