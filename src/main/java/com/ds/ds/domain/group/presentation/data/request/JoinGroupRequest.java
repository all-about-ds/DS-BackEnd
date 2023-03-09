package com.ds.ds.domain.group.presentation.data.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@Builder
@RequiredArgsConstructor
public class JoinGroupRequest {
    private final Optional<String> password;
}
