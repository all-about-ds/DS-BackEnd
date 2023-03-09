package com.ds.ds.domain.group.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@Builder
@RequiredArgsConstructor
public class JoinGroupDto {
    private final Long groupIdx;
    private final Optional<String> password;
}
