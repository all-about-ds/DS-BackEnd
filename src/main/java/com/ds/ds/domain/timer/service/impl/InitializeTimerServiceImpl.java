package com.ds.ds.domain.timer.service.impl;

import com.ds.ds.domain.timer.domain.entity.Timer;
import com.ds.ds.domain.timer.domain.repository.TimerRepository;
import com.ds.ds.domain.timer.service.InitializeTimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class InitializeTimerServiceImpl implements InitializeTimerService {
    private final TimerRepository timerRepository;

    @Override
    public void updateTimer() {
        List<Timer> timerList = timerRepository.findAll();

        timerList.stream()
                .forEach(Timer::initializeTime);

        timerRepository.saveAll(timerList);
    }
}
