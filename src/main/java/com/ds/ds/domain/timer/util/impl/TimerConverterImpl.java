package com.ds.ds.domain.timer.util.impl;

import com.ds.ds.domain.timer.presentation.data.dto.StopTimerDto;
import com.ds.ds.domain.timer.presentation.data.request.StopTimerRequest;
import com.ds.ds.domain.timer.util.TimerConverter;
import org.springframework.stereotype.Component;

@Component
public class TimerConverterImpl implements TimerConverter {
    @Override
    public StopTimerDto toDto(StopTimerRequest request) {
        return StopTimerDto.builder()
                .time(request.getTime())
                .build();
    }
}
