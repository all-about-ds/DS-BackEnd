package com.ds.ds.domain.timer.presentation.data.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class TimerResponse {
    private final Long idx;
    private final Long time;
    private final Boolean activity;
    private final List<MemberTimerResponse> memberTimerList;

    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class MemberTimerResponse {
        private final Long idx;
        private final Long time;
        private final Boolean activity;
    }
}
