package com.ds.ds.domain.timer.util;

import com.ds.ds.domain.timer.presentation.data.dto.StopTimerDto;
import com.ds.ds.domain.timer.presentation.data.request.StopTimerRequest;

public interface TimerConverter {
    StopTimerDto toDto(StopTimerRequest request);
}
