package com.ds.ds.domain.group.presentation.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class UpdateGroupRequest {
    private final String name;
    private final String description;
    private final String img;
    private final Long maxCount;
    private final Boolean secret;
    private final Optional<String> password;
}
