package com.ds.ds.domain.auth.presentation.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SearchPasswordDto {
    private final String email;
    private final String password;
    private final String checkPassword;
}
