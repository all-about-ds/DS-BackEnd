package com.ds.ds.domain.timer.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class StopTimerDto {
    private final Long time;
}
