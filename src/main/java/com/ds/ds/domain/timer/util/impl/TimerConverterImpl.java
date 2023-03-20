package com.ds.ds.domain.timer.util.impl;

import com.ds.ds.domain.timer.domain.entity.Timer;
import com.ds.ds.domain.timer.presentation.data.dto.StopTimerDto;
import com.ds.ds.domain.timer.presentation.data.dto.TimerDto;
import com.ds.ds.domain.timer.presentation.data.request.StopTimerRequest;
import com.ds.ds.domain.timer.presentation.data.response.TimerResponse;
import com.ds.ds.domain.timer.util.TimerConverter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimerConverterImpl implements TimerConverter {
    @Override
    public StopTimerDto toDto(StopTimerRequest request) {
        return StopTimerDto.builder()
                .time(request.getTime())
                .build();
    }

    @Override
    public TimerDto toDto(Timer userTimer, List<TimerDto.MemberTimerDto> dtoList) {
        return TimerDto.builder()
                .idx(userTimer.getIdx())
                .time(userTimer.getTimer())
                .activity(userTimer.getActivity())
                .memberTimerList(dtoList)
                .build();
    }

    @Override
    public TimerDto.MemberTimerDto toDto(Timer timer) {
        return TimerDto.MemberTimerDto.builder()
                .idx(timer.getIdx())
                .time(timer.getTimer())
                .activity(timer.getActivity())
                .build();
    }

    @Override
    public TimerResponse toResponse(TimerDto dto, List<TimerResponse.MemberTimerResponse> responses) {
        return TimerResponse.builder()
                .idx(dto.getIdx())
                .time(dto.getTime())
                .activity(dto.getActivity())
                .memberTimerList(responses)
                .build();
    }

    @Override
    public TimerResponse.MemberTimerResponse toResponse(TimerDto.MemberTimerDto dto) {
        return TimerResponse.MemberTimerResponse.builder()
                .idx(dto.getIdx())
                .time(dto.getTime())
                .activity(dto.getActivity())
                .build();
    }
}
