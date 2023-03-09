package com.ds.ds.domain.user.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class UpdateUserProfileImgDto {
    private final String updateUserProfileImg;
}
