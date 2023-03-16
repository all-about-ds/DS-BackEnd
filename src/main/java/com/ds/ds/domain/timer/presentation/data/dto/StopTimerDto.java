package com.ds.ds.domain.timer.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@Getter
@Builder
@RequiredArgsConstructor
public class StopTimerDto {
    private final LocalTime time;
}
