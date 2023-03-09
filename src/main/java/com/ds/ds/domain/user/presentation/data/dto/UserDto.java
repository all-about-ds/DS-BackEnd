package com.ds.ds.domain.user.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class UserDto {
    private final String name;
    private final String profileImg;
    private final List<GroupDto> groups;

    @Getter
    @Builder
    @RequiredArgsConstructor
    public class GroupDto {
        private final Long idx;
        private final String name;
        private final String img;
    }
}