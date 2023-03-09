package com.ds.ds.domain.user.presentation.data.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class UpdateUserProfileRequest {
    private final String profileImg;
}
