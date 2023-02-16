package com.ds.ds.domain.auth.presentation.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class TokenResponseDto {
    private final String accessToken;
    private final String refreshToken;
    private final LocalDateTime expiredAt;
}
