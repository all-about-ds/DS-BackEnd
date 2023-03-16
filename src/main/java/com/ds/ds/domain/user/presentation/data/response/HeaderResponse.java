package com.ds.ds.domain.user.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class HeaderResponse {
    private final String name;
    private final String img;
}
