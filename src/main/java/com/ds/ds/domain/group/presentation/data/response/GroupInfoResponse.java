package com.ds.ds.domain.group.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class GroupInfoResponse {
    private final String groupName;
    private final String groupImg;
    private final String groupDescription;
    private final Long groupmemberCount;
    private final Long groupMaxCount;
    private final String groupLeaderImg;
    private final String groupLeaderName;
    private final Boolean secret;
}
