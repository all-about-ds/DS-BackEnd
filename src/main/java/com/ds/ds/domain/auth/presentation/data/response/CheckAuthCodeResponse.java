package com.ds.ds.domain.auth.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class CheckAuthCodeResponse {
    private final String email;
}
