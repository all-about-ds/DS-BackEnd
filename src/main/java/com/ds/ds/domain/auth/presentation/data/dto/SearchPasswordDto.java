package com.ds.ds.domain.auth.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class SearchPasswordDto {
    private final String email;
    private final String password;
    private final String checkPassword;
}
