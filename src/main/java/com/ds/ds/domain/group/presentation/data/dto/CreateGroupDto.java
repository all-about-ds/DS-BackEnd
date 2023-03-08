package com.ds.ds.domain.group.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@Builder
@RequiredArgsConstructor
public class CreateGroupDto {
    private final String groupName;
    private final String groupDescription;
    private final String groupImg;
    private final Long groupMaxCount;
    private final Boolean secret;
    private final Optional<String> password;
}
