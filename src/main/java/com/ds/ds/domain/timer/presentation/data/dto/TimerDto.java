package com.ds.ds.domain.timer.presentation.data.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class TimerDto {
    private final Long timerIdx;
    private final LocalTime time;
    private final Boolean activity;
    private final List<MemberTimerDto> timerList;

    @Getter
    @RequiredArgsConstructor
    protected class MemberTimerDto {
        private final Long timerIdx;
        private final LocalTime time;
        private final Boolean activity;
    }
}
