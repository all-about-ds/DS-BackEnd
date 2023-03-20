package com.ds.ds.domain.timer.presentation.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class TimerDto {
    private final Long idx;
    private final Long time;
    private final Boolean activity;
    private final List<MemberTimerDto> memberTimerList;

    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class MemberTimerDto {
        private final Long idx;
        private final Long time;
        private final Boolean activity;
    }
}
