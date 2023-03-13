package com.ds.ds.domain.group.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class GroupMainResponse {
    private final Long idx;
    private final String groupName;
    private final String groupImg;
    private final String groupDescription;
    private final boolean header;
    private final MemberResponse head;
    private final List<MemberResponse> memberList;
}
