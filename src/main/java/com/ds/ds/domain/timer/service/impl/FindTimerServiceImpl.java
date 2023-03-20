package com.ds.ds.domain.timer.service.impl;

import com.ds.ds.domain.timer.presentation.data.dto.TimerDto;
import com.ds.ds.domain.timer.service.FindTimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindTimerServiceImpl implements FindTimerService {
    @Override
    public TimerDto findTimer(Long groupIdx) {
        return null;
    }
}
