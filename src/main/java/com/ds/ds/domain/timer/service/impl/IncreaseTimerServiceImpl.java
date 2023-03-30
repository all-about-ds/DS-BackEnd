package com.ds.ds.domain.timer.service.impl;

import com.ds.ds.domain.timer.domain.repository.TimerRepository;
import com.ds.ds.domain.timer.service.IncreaseTimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class IncreaseTimerServiceImpl implements IncreaseTimerService {
    private final TimerRepository timerRepository;

    @Override
    public void increaseTimer() {
        timerRepository.updateTimer();
    }
}
