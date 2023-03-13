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
    private final String groupName;
    private final String groupImg;
    private final String groupDescription;
    private final boolean host;
    private final MemberDto head;
    private final List<MemberDto> memberList;
}
