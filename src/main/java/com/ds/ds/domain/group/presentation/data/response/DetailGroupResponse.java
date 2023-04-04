package com.ds.ds.domain.group.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class DetailGroupResponse {
    private final Boolean isMember;
}
