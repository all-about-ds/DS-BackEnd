package com.ds.ds.domain.group.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class PopularityGroupListResponse {
    private final Integer size;
    private final Integer page;
    private final List<PopularityGroupResponse> groups;
}
