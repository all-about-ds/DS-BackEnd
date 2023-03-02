package com.ds.ds.domain.group.presentation.data.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@Builder
@RequiredArgsConstructor
public class GroupListRequest {
    private final Integer Size;
    private final Integer page;
    private final Optional<String> keyword;
}
