package com.ds.ds.domain.user.presentation.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateUserProfileDto {
    private final String profileImg;
}
