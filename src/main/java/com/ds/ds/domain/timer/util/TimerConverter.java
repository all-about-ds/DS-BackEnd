package com.ds.ds.domain.timer.util;

import com.ds.ds.domain.timer.domain.entity.Timer;
import com.ds.ds.domain.timer.presentation.data.dto.StopTimerDto;
import com.ds.ds.domain.timer.presentation.data.dto.TimerDto;
import com.ds.ds.domain.timer.presentation.data.request.StopTimerRequest;
import com.ds.ds.domain.timer.presentation.data.response.TimerResponse;

import java.util.List;

public interface TimerConverter {
    StopTimerDto toDto(StopTimerRequest request);
    TimerDto toDto(Timer userTimer, List<TimerDto.MemberTimerDto> dtoList);
    TimerDto.MemberTimerDto toDto(Timer timer);
    TimerResponse toResponse(TimerDto dto, List<TimerResponse.MemberTimerResponse> responses);
    TimerResponse.MemberTimerResponse toResponse(TimerDto.MemberTimerDto dto);
}
