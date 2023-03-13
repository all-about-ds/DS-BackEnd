package com.ds.ds.domain.group.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class GroupResponse {
    private final Long idx;
    private final String groupName;
    private final String groupImg;
    private final String groupDescription;
    private final Long groupMemberCount;
    private final Long groupMaxCount;
    private final String groupLeaderImg;
    private final String groupLeaderName;
    private final Boolean secret;
}
