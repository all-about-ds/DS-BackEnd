package com.ds.ds.domain.timer.presentation.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@Getter
@RequiredArgsConstructor
public class StopTimerRequest {
    private final LocalTime time;
}
