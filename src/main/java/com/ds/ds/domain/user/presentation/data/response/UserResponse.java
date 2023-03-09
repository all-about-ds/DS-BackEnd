package com.ds.ds.domain.user.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class UserResponse {
    private final Long idx;
    private final String name;
    private final String profileImg;
    private final List<GroupResponse> groups;

    @Getter
    @Builder
    @RequiredArgsConstructor
    public class GroupResponse {
        private final Long idx;
        private final String name;
        private final String img;
    }
}
