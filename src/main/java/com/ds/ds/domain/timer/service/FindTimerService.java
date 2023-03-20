package com.ds.ds.domain.timer.service;

import com.ds.ds.domain.timer.presentation.data.dto.TimerDto;

public interface FindTimerService {
    TimerDto findTimer(Long groupIdx);
}
