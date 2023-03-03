package com.ds.ds.domain.auth.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class CheckAuthCodeDto {
    private final String email;
}
