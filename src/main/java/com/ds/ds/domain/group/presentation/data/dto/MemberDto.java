package com.ds.ds.domain.group.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class MemberDto {
    private final Long idx;
    private final String name;
    private final String img;
}
