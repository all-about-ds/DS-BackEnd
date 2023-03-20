package com.ds.ds.domain.timer.presentation.data.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class TimerResponse {
    private final Long timerIdx;
    private final LocalTime time;
    private final Boolean activity;
    private final List<MemberTimerResponse> timerList;

    @Getter
    @RequiredArgsConstructor
    protected class MemberTimerResponse {
        private final Long timerIdx;
        private final LocalTime time;
        private final Boolean activity;
    }
}
