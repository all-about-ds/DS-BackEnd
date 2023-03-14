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
    private final String name;
    private final String img;
    private final String description;
    private final boolean host;
    private final MemberResponse head;
    private final List<MemberResponse> memberList;
}
