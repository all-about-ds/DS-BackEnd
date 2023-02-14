package com.ds.ds.domain.auth.domain.entity;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;
import java.util.UUID;

@RedisHash(value = "refreshToken")
public class RefreshToken {
    @Id
    @Indexed
    private UUID userId = null;
    @Indexed
    private String token;
}
