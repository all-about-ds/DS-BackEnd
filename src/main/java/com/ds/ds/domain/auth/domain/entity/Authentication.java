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
@RedisHash(value = "Authentication")
public class Authentication {
    @Id
    @Indexed
    private String email;

    @Builder
    public Authentication(String email){
        this.email = email;
    }
}
