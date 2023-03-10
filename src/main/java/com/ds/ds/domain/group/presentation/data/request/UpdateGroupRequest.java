package com.ds.ds.domain.group.presentation.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class UpdateGroupRequest {
    private final String groupName;
    private final String groupDescription;
    private final String groupImg;
    private final Long groupMaxCount;
    private final Boolean secret;
    private final Optional<String> password;
}
