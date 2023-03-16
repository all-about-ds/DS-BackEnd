package com.ds.ds.domain.group.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@Builder
@RequiredArgsConstructor
public class UpdateGroupDto {
    private final String name;
    private final String description;
    private final String img;
    private final Long maxCount;
    private final Boolean secret;
    private final String password;
}
