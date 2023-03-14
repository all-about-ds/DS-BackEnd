package com.ds.ds.domain.group.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class GroupMainDto {
    private final Long idx;
    private final String name;
    private final String img;
    private final String description;
    private final boolean host;
    private final MemberDto head;
    private final List<MemberDto> memberList;
}
