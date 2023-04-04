package com.ds.ds.domain.group.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class PopularityGroupResponse {
    private final Long idx;
    private final String name;
    private final String img;
    private final String description;
    private final Long memberCount;
    private final Long maxCount;
    private final String leaderImg;
    private final String leaderName;
    private final Boolean secret;
}