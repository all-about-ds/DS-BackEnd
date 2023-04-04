package com.ds.ds.domain.group.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class PopularityGroupListDto {
    private final Pageable pageable;
    private final List<PopularityGroupDto> groups;
}
