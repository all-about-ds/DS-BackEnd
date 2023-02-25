package com.ds.ds.domain.auth.presentation.data.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class TokenResponse {
    private final String accessToken;
    private final String refreshToken;
    @JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private final LocalDateTime accessExp;
    @JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private final LocalDateTime refreshExp;
}
