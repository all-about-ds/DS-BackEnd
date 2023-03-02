package com.ds.ds.domain.group.presentation.data.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Getter
@Builder
@RequiredArgsConstructor
public class GroupListSearchRequirementDto {
    private final Pageable pageable;
    private final Optional<String> keyword;
}
